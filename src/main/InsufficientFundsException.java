package main;


//This part is to indicate the exception for system to recognize if there is 
//InsufficientFunds exists.

public class InsufficientFundsException extends Exception
{
   private double amountMoney;
  

   public InsufficientFundsException(double amountMoney)
   {
      this.amountMoney = amountMoney;
   } 
   public double getAmountMoney()
   {
      return amountMoney;
   }
}