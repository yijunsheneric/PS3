
package JunitTest;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Account;
import main.InsufficientFundsException;

public class JunitTestOne {
	
	Account Tester = new Account(1122,20000,4.5);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Tester.setBalance(20000);
		Tester.setId(1122);
		Tester.setAnnualInterestRate(4.5);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	//test withdraw (true)
	@Test
	public void testWithdrawTrue() {
		try {
			assertTrue(Tester.withdraw(2500)==17500);
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		System.out.println(Tester.getBalance());
		System.out.println(Tester.getAnnualInterestRate());
		System.out.println(Tester.getDateCreated());
	}
	
	
	//test withdraw (false)
	@Test
	public void testWithdrawFalse() {
		try {
			assertFalse(Tester.withdraw(2500)!=20000);
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		System.out.println(Tester.getBalance());
		System.out.println(Tester.getAnnualInterestRate());
		System.out.println(Tester.getDateCreated());
	}
	
	
	@Test(expected=InsufficientFundsException.class)
	public void testOverDraw() throws InsufficientFundsException{
		Tester.withdraw(25000);
	}
	
	
	//test deposit (true)
		@Test
		public void testDepositTrue() {
				assertFalse(Tester.deposit(3000)==23000);
			
			System.out.println(Tester.getBalance());
			System.out.println(Tester.getAnnualInterestRate());
			System.out.println(Tester.getDateCreated());
		}
		

}