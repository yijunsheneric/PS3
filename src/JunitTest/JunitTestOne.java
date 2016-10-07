package JunitTest;


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
		Test.setBalance(20000);
		Test.setId(1122);
		Test.setAnnualInterestRate(4.5);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	//test withdraw (true)
	@Test
	public void testWithdrawTrue() {
		try {
			assertTrue(Test.withdraw(2500)==17500);
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		System.out.println(Test.getBalance());
		System.out.println(Test.getAnnualInterestRate());
		System.out.println(Test.getDateCreated());
	}
	
	
	//test withdraw (false)
	@Test
	public void testWithdrawFalse() {
		try {
			assertFalse(Test.withdraw(2500)!=20000);
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		System.out.println(Test.getBalance());
		System.out.println(Test.getAnnualInterestRate());
		System.out.println(Test.getDateCreated());
	}
	
	
	@Test(expected=InsufficientFundsException.class)
	public void testOverDraw() throws InsufficientFundsException{
		Test.withdraw(25000);
	}
	
	
	//test deposit (true)
		@Test
		public void testDepositTrue() {
				assertFalse(Test.deposit(3000)==23000);
			
			System.out.println(Test.getBalance());
			System.out.println(Test.getAnnualInterestRate());
			System.out.println(Test.getDateCreated());
		}
		

}