package testlab4;

import static org.junit.Assert.*;
import org.junit.*;

public class BPtest {
	private BackPack demo;
	
	@Before
	public void setUp() throws Exception {
		 demo = new BackPack();
	}
	@Test
	public void test(){
		demo=new BackPack();
		int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
		int[][] result = {{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,4,4,4,4,4,4,4,4},{0,0,0,4,5,5,5,9,9,9,9},{0,0,0,4,5,6,6,9,10,11,11}};
		assertArrayEquals(result,BackPack.BackPack_Solution(10, 3, w, p));
	}
	@After
	public void tearDown() throws Exception {
        demo = null;
    }
}
