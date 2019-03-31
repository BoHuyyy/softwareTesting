package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestInformation {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	//使用org.apache.poi读取excel文件，返回存取student对象的
	public static List<student> readXls() throws Exception{
		List<student> list = new ArrayList<student>();
		InputStream is = new FileInputStream("F:/大三下/软件测试/实验二/软件测试名单.xlsx");
		XSSFWorkbook excel = new XSSFWorkbook(is);
        student stu = null;
        for (int numSheet = 0; numSheet < excel.getNumberOfSheets(); numSheet++) {
            XSSFSheet sheet = excel.getSheetAt(numSheet);
            if (sheet == null)
                continue;
            // 循环行Row
            for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);
                if (row == null)
                    continue;
                stu = new student();
                //存入id和密码
                XSSFCell cell1 = row.getCell(1);
                if (cell1 == null)
                    continue;
                cell1.setCellType(CellType.STRING);
                stu.setId(cell1.getStringCellValue());
                stu.setPassword(cell1.getStringCellValue().substring(4));
                //System.out.println(cell1.getStringCellValue());
                //存入git地址
                XSSFCell cell3 = row.getCell(3);
                if (cell3 == null)
                    continue;
                cell3.setCellType(CellType.STRING);
                stu.setGit(cell3.getStringCellValue());
                //System.out.println(cell3.getStringCellValue());
                list.add(stu);
            }
        }
		return list;
	}
	
	@Before
	public void setUp() throws Exception {
		String driverPath = "F:/Java/testlab2/src/driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.firefox.bin", "F:/firefox/firefox.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://121.193.130.195:8800";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testInformation() throws Exception {
		//读取excel并且生成存储student对象的list，存入list
		List<student> list = readXls();
		driver.get(baseUrl + "/login");
		//对list进行遍历逐一测试
		for(student stu : list){
//			WebElement we = driver.findElement(By.name("id"));
//			we.click();
			driver.findElement(By.name("id")).clear();
			driver.findElement(By.name("id")).sendKeys(stu.getId());
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(stu.getPassword());
			WebElement btn = driver.findElement(By.id("btn_login"));
			btn.sendKeys(Keys.ENTER);
			assertEquals(stu.getGit(), driver.findElement(By.id("student-git")).getText());
			//logout
			WebElement out = driver.findElement(By.id("btn_logout"));
			out.sendKeys(Keys.ENTER);
			//return
			WebElement Return = driver.findElement(By.id("btn_return"));
			Return.sendKeys(Keys.ENTER);
			
			//break;
		}

	}
}
