// import so we can use Scanner to capture user input from the keyboard
import java.util.Scanner ;

/**
* ClassName: Assignment4 - The purpose of this program is to allow the user to calculate how much commission they
* made for selling the properties. The program loops till the user quits then prints summary of transactions.
*
*
*<pre>
* Assignment: #4
* Course: ADEV-1003
* Version: 1.0
* Date created: October 5, 2015
*
* Revision Log
* WHO          WHEN        REASON
* ---------------------------------
*
* </pre>
*
* @author Bradley Kirkbride-Taylor
* @version 1.0*
*/

public class RealEstate 
{
    /**
    * main -Runs the program, asks user for properties sold, calculates commission and loops till user quits.
    *
    * @param String[] args -  Uses arguments provide by user in the command line. This is no utilized in this 
    * program.
    */
   
    public static void main(String[] args)
    {
        
        //price of property entered 
        double price ;
       
        // comission that is earned per sale
        double commission = 0 ;
        
        // sum of all sales proccessed
        double totalSales = 0 ;
        
        // sum of all comissions proccessed
        double totalCommissions = 0 ;
        
        // stores the users response if they want to continue 
        char continueCode ;
        
        // stores the property code the user responded with
        char propertyCode ;
        
        // boolean flag for if the property code is valid
        boolean goodCode  ;
        
        
        // Property codes the user can enter
        // Property code for residential property
        final char RESIDENTIAL = 'R' ;
        
        // Property code for Multi-plex property
        final char MULTI = 'M' ;
        
        // Property code for Commercial property
        final char COMMERCIAL = 'C' ;
        
        // Commission values for property types 
        // Commission for selling a resedntial property
        final double RES_COMMISSION  = .07 ;
        
        // Commission for selling a multi-plex property
        final double MULTI_COMMISSION = .06 ;
        
        // commission for selling commerical proerty
        final double COMMERCIAL_COMMISSION = .035 ;
        
        // create Scanner object and initalize it
        Scanner input = new Scanner(System.in) ;
        
        // Print the welcome header
        System.out.println("Real-Estate Commission Calculator") ;
        System.out.println("---------------------------------\n") ;
        
        // Enter do while loop program runs atleast once
        do
        {
            // Prompt user for price of property sold.
            System.out.print("Enter the property's selling price: ") ;
            
            // Parse response into double and store it in price variable
            price = Double.parseDouble( input.nextLine()) ;
            
            // Check to make sure price entered is a valid value
            while(price <= 0)
            {
                  // Print error message
                  System.out.println("**Error** - Selling price must be greater than zero\n") ;
                  
                  // Prompt user for another price
                  System.out.print("Enter the property's selling price: ") ;
                  
                  // parse response into a double and store it in the price variable
                  price = Double.parseDouble( input.nextLine() ) ;
                  
            }
            
            // add the price of the property to the 
            // running total of propreties sold
            totalSales += price ;
            
            // Print the property code types for the user
            // Print Resedential code
            System.out.println("\n\nResidential\tR") ;
            
            // Print the mult-dwelling code
            System.out.println("Multi-Dwelling\tM") ;
            
            // Print the commerical code
            System.out.println("Commercial\tC\n") ;
            
            // Find out which type of property was sold
            do
            {
                // Prompt user for the property code for the 
                // type of property the sold
                System.out.print("Enter the property code: ") ;
                
                // read input from keyboard and convert the response to UPPER CASE
                // extract the first character of the response and
                // store it in a char variable
                propertyCode = (input.nextLine()).toUpperCase().charAt(0) ;
                
                // Test which property code was entered
                switch(propertyCode)
                {
                    case RESIDENTIAL :
                    
                        // calculate the commission from selling resedential property
                        commission = price * RES_COMMISSION ;
                        
                        // add calculated commission to running total of commissions
                        totalCommissions += commission ;
                        
                        // Property code is valid so set goodCode to true
                        goodCode = true ;
                        
                        // used to get out of switch statment
                        break ;
                    
                    case MULTI :
                    
                        // Calculate commission from selling multi-
                        commission = price * MULTI_COMMISSION ;
                        
                        // add calculated commission to running total of commissions
                        totalCommissions += commission ;
                        
                        // Property code is valid so set goodCode to true
                        goodCode = true ;
                        break ;
                        
                    case COMMERCIAL :
                    
                        // calculate the commission for a commercial property
                        commission = price * COMMERCIAL_COMMISSION ;
                        
                        // add calculated commission to running total of commissions
                        totalCommissions += commission ;
                        
                        // Property code is valid so set goodCode to true
                        goodCode = true ;
                        break;
                        
                     // if a valid code isn't entered then the default case runs
                     default:
                     
                        // print error message for bad propery code.
                        System.out.println("\n**Error** - property code must be R, M or C\n") ;
                        
                        // set good code to false
                        goodCode = false ;
                        
                }
            }
            // go back to the do and repeat this loop 
            // until the user enters a valid property code
            while(!goodCode) ;
            
            // The user has entered a valid code so now print how much commission was made 
            // on the sale
            System.out.print("\nTotal commission on this property is $" + commission +"\n\n") ;
            
            // Ask the user if they want to calculate another commission
            System.out.print("Calculate another commission? (y/n): ") ;
            
            // read input from keyboard and  convert the response to lower case
            // extract the first character of the response and
            // store it in a char variable
            continueCode = input.nextLine().toLowerCase().charAt(0) ;
            
            // Print out a new line
            System.out.println() ;
            
            
            // Check to see if the user responded with 'y' or 'n'
            while( !(continueCode == 'y' || continueCode == 'n'))
            {
                // Print error message 
                System.out.println("**Error** - Invalid response\n") ;
                
                // Ask user again if they want to calculate another commission
                System.out.print("Calculate another commission? (y/n): ") ;
                
                // read input from keyboard and convert the response to lowercase
                // extract the first character of the response and store it in a char variable
                continueCode = input.nextLine().toLowerCase().charAt(0) ;
            }
            // Print a new line
            System.out.println() ;
        }
        // If the user entered 'y' continue the loop
        // if the user entered 'n' quit the loop 
        // (dont need to test for n because there are only two possible respones)
        while (continueCode == 'y' );
        
        // Print The ending header
        System.out.println("Transaction Summary") ;
        System.out.println("-------------------") ;
        
        // Print how much the agent did in total sales
        System.out.println("Total property sales: $" + totalSales) ;
        
        // Print the total commission earned
        System.out.println("Total Commissions: $" + totalCommissions) ;
        
        //End of the main method
    }
}