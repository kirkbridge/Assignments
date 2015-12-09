/**
 * Savings: This is a class that is used to define Savings instances. It allows users to 
 * Send balance and interest rate.
 *
 *<pre>
 * Assignment 7
 * Course: ADEV-1003
 * Version: 1.0
 * Date Created: November 16, 2015
 * 
 * Revision Log 
 * WHO              WHEN                REASON
 * -------------------------------------------
 * 
 * </pre>
 * 
 * @author Bradley Kirkbride-Taylor
 * @version 1.0
 */
public class Savings
{
	// holds the current balance of the account
	private double balance ;

	// holds the current interest rate to the account
	private double interestRate ;


	/**
	*Savings - Constructor for the Savings class. It sets the beginning balance and 
	*	the starting annual interest rate.
	*
	* @param balance - the intial balance of the account
	* @param rate - the annual rate of interest earned by the account 
	*/
	public Savings(double balance, double interestRate) 
	{
		// set account balance to balance provided
		this.balance = balance ;

		// set account interest rate to interest rate provided 
		// Its the ANNUAL interest rate
		this.interestRate = interestRate  ;
	
	}

	/**
	* getBalance - returns the balance of the account
	*
	* @return - The balance of savings account
	*/
	public double getBalance()
	{
		// return current balance
		return balance ;
	}

	/**
	* getInterestRate - get the current interest rate of the account
	*
	* return - the interest rate
	*
	*/
	public double getInterestRate()
	{
		// return interest rate
		return interestRate ;
	}

	/**
	*setInterestRate - set the interest rate to the new value provided
	*
	* @param - new interest rate
	*/
	public void setInterestRate(double rate)
	{
		// change interest rate to the rate provided
		interestRate = rate ;
	}

	/**
	* withdraw amount - subtract that amount specified from the account
	*
	* @param amount - the amount to be withdrawn from the account
	*/
	public void withdraw(double amount) 
	{
		// subtract the how much is withdrawn from the balance
		// and set that as the new balance
		balance-= amount ;
			
	}

	/**
	* deposit - add the amount to the balance
	*
	* @param amount - the amount to be add to the balance
	*/
	public void deposit(double amount) 
	{
		// add the amount deposited to the balance 
		// and set that as the new balance
		balance += amount ;
		
	}

	/**
	* calculateInterest - calculates the interest earned for the month. If balance is zero or less
	* 		then the interest earned is zero.
	*
	* @return - the amount interest earned
	*/
	public double calculateInterest()
	{
		// the interest that has been accumulated
		double interest = 0;

		// if balance is negative or zero no interest is accumulated
		if(balance > 0)
		{	
			// calculate the interest for the month (using monthly interest rate)
			interest = balance * ((interestRate / 100) / 12) ;
		}

		// return calculated interest for the month
		return interest ;
	}

}