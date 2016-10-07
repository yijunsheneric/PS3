package main;

import java.util.Date;

public class Account {

//	This Section present the variables in the account class, and those variables
//  would help the system gathering more information about customer. However, 
//  those variables named by requirement in the instruction. 
	
	private int Identification; 
	private double balance, annualInterestRate;
	private Date dateCreated;
		
	public Account(int Identification, double Startingbalance, double Rate){
		super(); 
		this.Identification=Identification;
		this.balance=Startingbalance;
		this.annualInterestRate=Rate;
		this.dateCreated=new Date();
	}

	
// This part is to get the setting Id, getting Balance, setBalance, annualinterestrate 
// and get date. 
		
		public void settingId(int id) {
			this.Identification = id;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public double getAnnualInterestRate() {
			return annualInterestRate;
		}

		public void setAnnualInterestRate(double annualInterestRate) {
			this.annualInterestRate = annualInterestRate;
		}

		public Date getDateCreated() {
			return dateCreated;
		}
	
	
	
// This is the no-arg constructor that creates a default account according to the 
// requirement in the instruction. 
	
	
	public Account(){
		this(0,0,0);
	}
	
// In account,  we use this part to get initial information for the account. However,
// we do set up the starting balance to zero. 
	
	public Account(int Identification, double balance){
		this(Identification,balance,0);
	}


	
	
// This section is to get the monthly interest rate. However, since we had the 
// annual interest rate, we are going to use the annual interest rate to divide 12
// in order to get the Monthly Interest Rate. 

	public double getMonthlyInterestRate(){
		return this.annualInterestRate/12;
	}

// This section is going to get the balance by using the deposit amount of money. 

	
	public double deposit(double depositamount){
		this.setBalance(this.getBalance()+ depositamount); 
		return this.getBalance();
	}
	
// This section we were using deposit money and withdraw money to get the remanning 
// balance. 
	
	
	public double withdraw(double withdrawamount) throws InsufficientFundsException{
		if(withdrawamount>this.getBalance()){
			throw new InsufficientFundsException(withdrawamount-this.getBalance());
		}
		else{
			this.setBalance(this.getBalance()-withdrawamount);
		}
		return this.getBalance();
		
	}
	
	
}