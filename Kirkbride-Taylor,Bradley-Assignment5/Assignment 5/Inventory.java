// imports that required library to use Scanner
import java.util.Scanner ;

/**
*  Inventory - The purpose of this program is to let an employee
* enter inventory for a specific item. The program will calculate
* how many different items the employee entered and the total value of 
* all the items 
*
*
*<pre>
* Assignment: #5
* Course: ADEV-1003
* Version: 1.0
* Date created: October 29, 2015
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
public class Inventory
{
    
    
    /**
     * main - the purpose of this method is to run the program, it will mainly be calling other methods.
     * 
     * @param args - accepts command line arguments, will not be utilized in this program.
     */
    public static void main(String[] args)
    {
        // The employee's name entering items
        String employeeName ;
        
        // The scanner input object used to get input from user
        Scanner input = new Scanner(System.in) ;
        
        // Number of different items entered by the employee
        int numberOfItemsEntered = 0 ;
        
        // Number of units on Hand
        int numOnHand = 0 ;
        
        // Price of indivdual unit
        double unitPrice = 0 ;
        
        // The value of all the items entered
        double totalValue = 0 ;
        
        //check if the user wants to continue
        char enterAnother ;
        
        // Print welcome message
        printWelcome() ;
        
        // Get employee name
        employeeName = getEmployeeName(input) ;
        
        // loop until that user quits
        do
        {
            // Get sku Number from user
            enterSku(input);
            
            // Get the description of inventory item
            enterDescription(input) ;
            
            // Get the number of items currently in their environment
            numOnHand = currentInventory(input) ;
            
            // Get the price of the inventory item
            unitPrice = getPrice(input) ;
            
            // Calculate the value of the inventory counted then 
            // add it to the running total of total value counted
            totalValue += calculateValue(numOnHand, unitPrice) ;
            
            // increment the number of items entered by the employee
            numberOfItemsEntered++ ;
            
            // Ask if we should continue
            enterAnother = keepGoing(input) ;
        }
        // Check response from user, if it is y or Y then keep prompt user for another item
        while(enterAnother == 'y' || enterAnother == 'Y') ;
        
        // print final inventory 
        printReport(employeeName,numberOfItemsEntered,totalValue) ;
        
        
        
    }
    
    /**
     * getEmployeeName - the purpose of this method is to get the name  of the employee
     * This method will check for empty names and throw an error.
     * 
     * @param input - object used to get user input from the keyboard
     * 
     * @return name - A valid name enterd by the user
     */
    private static String getEmployeeName(Scanner input)
    {
        // name entered by user
        String name ;
        
        // length of name entered
        int nameLength ;
        
        // loops until valid input is entered
        do
        {
            // Prompt user for their name
            System.out.print("Employee Name: ") ;
            
            // get user input from keyboard and store it in 
            // name variable
            name = input.nextLine() ;
            
            // remove blank spaces from name
            name = name.trim() ;
            
            // get length of name
            nameLength = name.length() ;
            
            // if nameLength is equal to zero
            if(nameLength == 0)
                // print the error message  
                System.out.println("\n**Error 01** - You must enter you name\n") ;
            
        }
        while(nameLength == 0);
        
        // Print a blank line
        System.out.println() ;
        
        // return valid name that was input from user
        return name ;
        
        
    }
    
    /**
     * enterSku - Propmt user for the SKU of the item they counted
     * This method will check length of SKU entered and if all the characters are all alphanumeric. 
     * 
     * @param input - object used to get user input from the keyboard
     */
    private static void enterSku(Scanner input)
    {
        // used to store the sku was entered
        String sku ;
        
        // the length of the sku entered
        int length ;
        
        // boolean used to keep track if it was a valid entry
        boolean isValid = true ;
        
        // Loop until the valid input is recieved from user
        do
        {
            // Print out prompt for user to enter a sku number
            System.out.print("Enter SKU number: ") ;
            
            // Capture input from the keyboard and store it in 
            // sku variable
            sku = input.nextLine() ;
            
            // trim out the white space from the input
            sku = sku.trim() ;
            
            // get the length of the sku entered
            length = sku.length() ;
            
            // Test to see if the length is 
            // five
            if( length == 5)
            {   
                // value entered is valid so set boolean to true
                isValid = true ;
            }
            else
            {
               // print out the error message
               System.out.println("\n**Error 02** - SKU number must be 5 character\n") ;
               
               // value entered is invalid so set boolean to false
               isValid = false ;
            }
            
        }
        // if the value entered is not valid go back to the top
        while(!(isValid));
        
    }
    
    /**
     * enterDescription - Propmt user for the description of the item they counted
     * This method will check length of the description, description must be longer than 0 but no more than
     * 20 characters long.
     * 
     * @param input - object used to get user input from the keyboard
     */
    private static void enterDescription(Scanner input)
    {
        // the description of the item entered in inventory
        String description ;
        
        int length ;
        
        // boolean used to keep track if it was a valid entry 
        boolean isValid  = true;
        
        do
        {
           // prompt user to enter a description
           System.out.print("Enter description: ") ;
           
           // store user's response in the description variable
           description = input.nextLine() ;
           
           // trim the leading and trailing whitespaces from the response
           description = description.trim() ;
           
           // how many characters the description is
           length  = description.length() ;
           
           // the description entered is blank
           if(length == 0 )
           {
               // print out the error message
               System.out.println("\n**Error 03** - Product description is required\n") ;
               
               // value entered is invalid so set boolean to false
               isValid = false ;
               
           }
           // the description entered is longer than 20 characters
           else if(length > 20)
           {
               // print out the error message
               System.out.println("\n**Error 04** - Product description is more than 20 characters\n") ;
               
               // value entered is invalid so set boolean to false
               isValid = false ;
           }
           // the description entered is valid
           else
           {
               // value entered is valid so set boolean to true
               isValid = true ;
           }
           
        }
        // keep looping until valid input is entered
        while(!isValid) ;
        
    }
    
    /**
     * currentInventory - Propmt user for the amount of the item they counted
     * This method will check length of the description, description must be longer than 0 but no more than
     * 20 characters long.
     * 
     * @param input - object used to get user input from the keyboard
     * 
     * @return inventory - the amount of inventory of particular item
     */
    private static int currentInventory(Scanner input)
    {
        // stores the amount of inventory entered
        int inventory ;
        
        // loop until a valid inventory number is entered
        do
        {
            // prompt the user to enter the quantity on hand
            System.out.print("Enter quantity on hand: ") ;
            
            // get input from user and convert it to an integer
            inventory = Integer.parseInt(input.nextLine()) ;
            
            // if the inventory is negative number
            if( inventory < 0 )
            {
                // print out the error message
                System.out.println("\n**Error 05** - Quantity on hand is a negative value\n") ;
            }
        }
        // keep loopintg until a valid value is entered
        while(inventory < 0);
        
        // return how much of the item is on hand
        return inventory ;
    }
    
    /**
     * currentInventory - Propmt user for the amount of the item they counted
     * This method will check length of the description, description must be longer than 0 but no more than
     * 20 characters long.
     * 
     * @param input - object used to get user input from the keyboard
     * 
     * @return price - the price of the particular item
     */
    private static double getPrice(Scanner input)
    {
        // stores the price entered by the user
        double price ;
        
        // get a valid price from the user
        do
        {
            // Prompt the user for the unit cost of the item
            System.out.print("Enter unit cost: ") ;
            
            // capture and convert the user's response into a double
            price = Double.parseDouble(input.nextLine()) ;
            
            // the price must be greater than or equal to .01 and less than or equal to 5000
            if(price < 0.01 || price > 5000)
            {
                // print out the error message
                System.out.println("\n**Error 06** - Unit cost must be a value between .01 - 5000.00\n") ;
            }
        }
        // keep looping until a valid price is entered
        while(price < 0.01 || price > 5000);
        
        // return the price entered by the user
        return price ;
    }
    
    /**
     * calculateValue - calculate how much the total inventory for a particular item is worth
     * 
     * @param howMany - the number of items the company has on hand
     * 
     * @param howMuch - the price of a single unit of this particular item
     * 
     * @return value - the value of all the inventory of that particular item
     */
    private static double calculateValue(int howMany, double howMuch)
    {
        // multiply how many units in the inventory by
        // the unit price of the inventory and return it
        return howMany * howMuch ;
    }
    private static char keepGoing(Scanner input)
    {
        // stores the result from the user
        char result ;
        
        // get a valid response from the user if they want to continue
        do
        {
            // ask user if they want to enter a number inventory
            System.out.print("\nEnter another item? (y/n): ") ;
            
            // take the first character of the user's response and store it in result
            result = input.nextLine().charAt(0) ;
            
            // test to see if it is valid respons
            if(!(result == 'y' || result == 'Y' || result == 'n' || result == 'N'))
                // print out the error message
                System.out.println("\n**Error** - Invalid Response\n") ;
            
        }
        // if the character entered is not valid repeat the loop
        while(!(result == 'y' || result == 'Y' || result == 'n' || result == 'N')) ;
        
        // return character entered by the user
        return result ;
    }
    
    /**
     * printWelcome - Welcomes the user to the program, prints the header.
     */
    private static void printWelcome()
    {
        // print the welcoming header
        System.out.println("Welcome to Java Mart Inventory System\n-------------------------------------") ;
    }
    
    /**
     * printReport - The final report which displays the employee's name how many differnt items they counted
     * and how much the total inventory they counted is worth.
     * 
     * @param name - Employee's name
     * 
     * @param numItems - the number of differnt items the employee counted
     * 
     * @param total - the total value of all the inventory counted by the employee
     */
    private static void printReport(String name, int numItems, double total)
    {
        // print out report header
        System.out.println("\nInventory Report") ;
        
        // print out spacer
        System.out.println("----------------") ;
        
        // print out who created the inventory 
        System.out.println("Inventory performed by: " + name) ;
        
        // print out how many different items employee entered
        System.out.println("Number of products counted: " + numItems) ;
        
        // print out how much the total inventory counted amounts too
        System.out.println("Total Inventory Cost: $" + total) ;
        
    }
        
}