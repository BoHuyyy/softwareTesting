package Test;

import org.junit.*;
import demo.moneyAlready;
import static org.junit.Assert.*;

public class testLab1 {
	private moneyAlready demo;
	@Test
	public void test1(){
		demo=new moneyAlready();
		assertEquals(1,demo.find(8));
	}
	@Test
	public void test2(){
		demo=new moneyAlready();
		assertEquals(1,demo.find(73));
	}
	@Test
	public void test3(){
		demo=new moneyAlready();
		assertEquals(0,demo.find(100));
	}
}
