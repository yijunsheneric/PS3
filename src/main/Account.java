package main;

import java.util.Date;

public class Account {

//	This Section present the variables to 
	
	private int id; 
	private double balance, annualInterestRate;
	private Date dateCreated;
		
	
	//Account Constructor
	public Account(int identification, double startingbalance, double rate){
		super(); // extends Object class
		this.id=identification;
		this.balance=startingbalance;
		this.annualInterestRate=rate;
		this.dateCreated=new Date();
	}
	
	//no-arg constructor that sets everything to 0
	public Account(){
		this(0,0,0);
	}
	
	//Account constructor that takes ID and balance, and sets rate = 0
	public Account(int iD, double BALANCE){
		this(iD,BALANCE,0);
	}

	
	
	//generates all getters and setters 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
	//getMonthlyInterestRate method
	public double getMonthlyInterestRate(){
		return this.annualInterestRate/12;
	}
	
	//Deposit - returns remaining balance
	public double deposit(double depositamount){
		this.setBalance(this.getBalance()+ depositamount); 
		return this.getBalance();
	}
	
	//Withdraw - returns remaining balance
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