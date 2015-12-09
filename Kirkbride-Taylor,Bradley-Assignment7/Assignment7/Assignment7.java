/**
 * Assignment7- The purpose of this program is to open a savings account and keep track of how 
 * the total deposits, withdrawls and interest earned month to month. As well as the total deposits,
 * withdrawls, interest and final balance after all transactions processed.
 * 
 * <pre>
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

public class Assignment7
{

     /**
    * main - the purpose of this method is to run the program, it will mainly be calling other methods.
    * 
    * @param args - accepts command line arguments. Will not be utilized in this program.
    */

    public static void main(String[] args)
    {
        // flag to see if file is open 
        boolean doesExist ;

        // an array to hold all of the transactions that take place on the account
        double[] accountInfo = null ;

        // An object used to open and read the file
        // instinate the object with the file Name that you want to process
        SavingsAccountFile file = new SavingsAccountFile("savings.txt") ;

        // see if file opened sucessfully
        doesExist = file.isOpen() ;

        // the file opened successfully
        if(doesExist)
        {
            // Get the transactions from the file
            accountInfo = file.getSavingsAccountData() ;
            
            // Process the transactions
            processData(accountInfo) ;
        }

        // the file did not open successfully
        else
        {
            // Print out error message
            System.out.println("The file does not exist or can not be opened.");
        }

    }

    /**
    * processData - Create a Savings Account and process all the transactions 
    * that have occurred.
    *
    * @param accountInfo - This is an array that has the account's inital information
    * as well as the monthly transactions that are to be proccessed.
    */
    private static void processData(double[] accountInfo)
    {
        // holds the amount of interest earned in the month
        double interest ;

        // stores how much was deposited from the account that month
        double deposit ;

        // stores how much was withdrawn fromt the account that month
        double withdrawl = 0;

        // Keeps a running total of all deposits since acount was opened
        double totalDeposit = 0 ;

        // keeps a running total of all interest accumulated since account was opened
        double totalInterest = 0 ;

        // keeps a running total of all withdrwals since account was opened
        double totalWithdrawls = 0;

        // The object that all the transaction data will be added too.
        Savings account ;

        
        // Create the instance of the Savings account 
        // Constructing it with a Starting balance and the Interest Rate
        account = new Savings(accountInfo[0], accountInfo[1]) ;

        // Print the inital balance of the account and the interest rate
        printHeading(account.getBalance(), account.getInterestRate()) ;

        // loop until all transactions are processed
        for(int i = 2 ; i < accountInfo.length ; i++)
        {
                // get the deposit amount from the array of transactions
                deposit = accountInfo[i] ;

                // Deposit the amount into the savings account
                account.deposit(deposit) ;

                // Add the deposit amount to total deposits 
                totalDeposit += deposit ;

                
                // get the withdrawl info from the array of transactions
                withdrawl = accountInfo[++i] ;

                // Withdraw the amount from the bank account balance
                account.withdraw(withdrawl) ;

                // Add the withdrawl amount to the total withdrawls 
                totalWithdrawls += withdrawl ;

                // Calculate interest earned that month
                interest = account.calculateInterest() ;

                // Deposit calculated interest earned
                account.deposit(interest) ;

                // Add interest to total interest accumulated
                totalInterest += interest ;

                // Print the transactions for that month
                printMonth(deposit, withdrawl, interest, account.getBalance() , i/2) ;
            
    
        }

        // Print the final report of transactions totals that occured
        printEndReport(totalDeposit, totalWithdrawls,totalInterest,account.getBalance()) ;
        

        
    }

    /**
    * printHeading - print the inital message to the user as well as printing the 
    *   intial balance and interest rate of the account.
    *
    * @param balance - the intial balance of the account
    * @param rate - the annual rate of interest earned by the account 
    */
    private static void printHeading(double balance , double rate)
    {
        // Print the heading 
        System.out.println("Savings Account Summary\n") ;

        // Print the starting balance
        System.out.println("Starting Balance:\t$" + balance) ;

        // print the interest rate for the account
        System.out.println("Annual Interest Rate:\t" + rate +"%" ) ;

        // print a blank a line
        System.out.println() ;

    }

    /**
    * printMonth - print the transaction summary for the month. 
    *   
    *
    * @param deposits - the total amount of deposits for the month
    * @param withdrawls - the total amount of withdrawls for the month
    * @param interest - the total amount of interest accured for the month 
    * @param balance - the remaining balance at the end of the month
    * @param month - the month that the transaction occurred
    */

    private static void printMonth(double deposits, double withdrawls, double interest, double balance, int month )
    {
        // Print the month the transaction occured in
        System.out.printf("Month %d\n--------\n", month) ;

        // Print the total Deposits for the month
        System.out.printf("Deposits:\t\t$%.2f\n",deposits) ;

        // Print the total Withdrawls for the month
        System.out.printf("Withdrawls:\t\t$%.2f\n",withdrawls) ;

        // Print the total Interest for the month
        System.out.printf("Interest Earned:\t$%.2f\n", interest) ;

        // Print the balance at the end of the month
        System.out.printf("Balance:\t\t$%.2f\n\n",balance) ;
    }


    /** 
    * printEndReport - print the total transaction summary since its existance. 
    *   
    *
    * @param deposits - the total amount of deposits after all transactions
    * @param withdrawls - the total amount of withdrawls after all transactions
    * @param interest - the total amount of interest accured after all transactions
    * @param balance - the remaining balance of the account after all transactions
    * 
    */
    private static void printEndReport(double deposit, double withdrawls, double interest, double balance)
    {
        // Print the total amount of deposits that occured
        System.out.printf("Total deposits:\t\t$%.2f\n",deposit);

        // Print the total amount of withdrawls that occured
        System.out.printf("Total withdrawls:\t$%.2f\n",withdrawls);

        // Print the total amount of interest that accumulated
        System.out.printf("Total interest earned:\t$%.2f\n",interest);

        // Print the ending balance of the account after all the transactions.
        System.out.printf("Ending balance:\t\t$%.2f\n",balance);

    }

    
}