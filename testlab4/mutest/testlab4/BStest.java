package testlab4;

import static org.junit.Assert.*;
import org.junit.*;

public class BStest {
	private BubbleSort demo;
	
	@Before
	public void setUp() throws Exception {
		 demo = new BubbleSort();
	}
	@Test
	public void test(){
		int arr[] = new int[]{1,6,2,2,5};
		int result[] = new int[]{1,2,2,5,6};
		assertArrayEquals(result,BubbleSort.BubbleSort(arr));
	}
	@After
	public void tearDown() throws Exception {
        demo = null;
    }
}
