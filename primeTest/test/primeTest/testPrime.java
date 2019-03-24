package primeTest;

import org.junit.Before;
import org.junit.Test;

public class testPrime {
	private PrintPrimes prime;
	
	@Before
	public void setup(){
		prime=new PrintPrimes();
	}
	
	@Test
	public void tests(){
		prime.printPrimes(5);
	}
}
