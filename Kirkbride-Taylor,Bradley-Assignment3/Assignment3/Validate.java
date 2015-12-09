// import scanner so the program can 
// capture input from user's keyboard
import java.util.Scanner ;

/**
* ClassName: Assignment3 - A user puts a value a date. The program checks 
* to see if the date is valid. If the date is valid it will print out
* the date in the format Name of month day, year.
*
*
*<pre>
* Assignment: #3
* Course: ADEV-1003
* Version: 1.0
* Date created: October 1, 2015
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

public class Validate
{
    /**
    * main -Runs the program, asks user for a date and then formats the date for them.
    *
    * @param String[] args -  Uses arguments provide by user in the command line. This is no utilized in this 
    * program.
    */
    public static void main(String[] args)
    {
        //stores the value of day
        int day ;
        
        //stores the value of the month
        int month ;
        
        //stores the value of the year
        int year ;
        
        //flag to check thorought program if date is valid
        boolean isValidDate = true ;
        
        // used to hold the final converted date value
        // must be intalized first because year value is 
        // added on to the end of the string
        String resultDate = "" ;
        
        //used for user input from keyboard
        Scanner input = new Scanner(System.in) ;
        
        //prompt user for day
        System.out.print("Day: ") ;
        
        //convert the value to day
        day = Integer.parseInt(input.nextLine()) ;
        
        //print a new line
        System.out.println() ; 
        
        //prompt user for month
        System.out.print("Month: ") ;
        
        // captures input from the user 
        //convert the value from string to int
        month = Integer.parseInt(input.nextLine()) ;
        
        //print a new line
        System.out.println() ;
        
        //prompt user for year
        System.out.print("Year: ") ;
        
        // convert the value from string to int
        year = Integer.parseInt(input.nextLine()) ;
        
        //print a new line
        System.out.println() ;
        
        //check to see if date entered is negative or zero or 
        //greater than 31
        if (day > 0 && day < 32 )
        {
            //check to see if the month is valid (1-12)
            switch(month)
            {
                // Month is January
                case 1:
                   
                   // set resultDate
                   resultDate = "January " + day + ", " ;
                   
                   // This will break out of the switch statement
                   // every preceding break statement will do this too.
                   break ;
                   
                // month is February   
                case 2:
                    //check to see if day is less then or equal to 28
                    if(day <= 28)
                    {
                        // set the resultDate
                        resultDate = "Februaruy " + day + ", " ;
                    }
                    
                    // if day is equal to 29 we need to check to see if it is a leap year
                    else if( day == 29)
                    {
                        // check if year is disvible by 4 and not 100 but is divisible by 400    
                        if(year%4 == 0 && ( year%100 != 0 || year %400 == 0))
                        {
                            // if it is a valid leap year add to resultDate
                            resultDate = "February " + day + ", " ;
                        }
                        
                        // if not a leap year print error message
                        else
                        {
                            // Print the error message
                            System.out.println("February only has 29 days on a leap year") ;
                            
                            // No longer a valid date so change boolean to false
                            isValidDate = false ;
                        }
        
                        
                    }
                    // if date is 30 or 31 print error message
                    else
                    {     
                          //user put an invalid day value for the month of February
                          //print an error message
                          System.out.println("Invalid day value for the month specified") ;
                          
                          // the date is no longer valid set boolean to false
                          isValidDate = false ;
                    }
                    break ;
                
                // Month is March
                case 3:
                
                    // add the result date 
                    resultDate = "March " + day + ", ";
                    break ;
                    
                // Month is April
                case 4:
                
                    //check to see if day is valid 
                    if( day <= 30)
                    {
                        //add the resut date
                        resultDate = "April " + day + ", " ;
                    }
                    
                    // if not a valid day for the month print error message
                    // and set error flag to false
                    else 
                    {
                        // print error message for bad day value  for month
                        System.out.println("Invalid day value for the month specified ") ;
                        
                        // set validDate = false
                        isValidDate = false ;
                    }
                    break ;
                
                // Month is May
                case 5:
                    
                    // set the result date
                    resultDate = "May " + day + ", " ;
                    break ;
                
                // Month is June
                case 6 :
                
                    //check to see if day is valid 
                    if( day <=30)
                    {
                        // set the result date
                        resultDate = "June " + day + ", " ;
                    }
                    
                    // if not a valid day for the month print error message
                    // and set error flag to false
                    else
                    {
                        //Print error message
                        System.out.println("Invalid day value for the month specfied ") ;
                        
                        // Set the validDate to false
                        isValidDate = false ;
                    }
                    break ;
                
                // Month is July
                case 7:
                
                   // set the result date
                   resultDate = "July "+ day + ", " ;
                   break ;
                
                // Month is August
                case 8:
                
                    // set the result date
                    resultDate = "August " + day + ", " ;
                    break ;
                
                // Month is September
                case 9:
                
                    //check to see if day is valid 
                    if(day <= 30)
                    {
                        resultDate = "September " + day + ", " ;
                    }
                    
                    // if not a valid day for the month print error message
                    // and set error flag to false
                    else
                    {   
                        //Print out error message
                        System.out.println("Invalid day value for the month specified") ;
                        
                        // Set the validDate to false
                        isValidDate = false ;
                    }
                    break;
                 
                // Month is October    
                case 10:
                
                    // set the result date
                    resultDate = "October " + day + ", " ;
                    break ;
                
                // Month is November
                case 11:
                   
                    //check to see if day is valid 
                    if(day <=30)
                    {
                        // set the result date
                        resultDate = "November " + day + ", " ;
                    }
                    
                    // if not a valid day for the month print error message
                    // and set error flag to false
                    else
                    {
                        //print error message
                        System.out.println("Invalid day value for the month specified") ;
                        
                        //set valid date to false
                        isValidDate = false ;
                    }
                    break ;
                 
                // Month is December
                case 12:
                
                    // set the result date   
                    resultDate = "December " + day + ", " ;
                    break ;
                
                // If an invalid month value entered print error message
                // and set validDate to false
                default:
                
                    // print the error message
                    System.out.println("Invalid month value ") ;
                    
                    // change validDate to false
                    isValidDate = false ;
                    break ;
            }
        }
        
        // if the day value entered is zero or less or 31 or greater
        else
        {  
            // print error message
            System.out.println("Invalid day value") ;
            
            // change valid date to false
            isValidDate = false ;
        }
        
        //check to see if the year entered is valid and 
        // if it is add the year to the end of the date.
        if(year >= 1582 && year < 10000)
        {
            // add year to the end of the 
            // formatted date
            resultDate += year ;
        }
        
        //this means year is invalid but first need to check
        //if any other error messages have already printed
        //if they haven't then this will be true and error message should print
        else if(isValidDate)
        {  
            // print the error message
            System.out.println("Invalid year value") ;
            
            // set the date to false
            isValidDate = false ;
        }
        
        //If no error messages have been printed
        //then this will be true and the date will print
        if(isValidDate)
        {
          //Print out the date
          System.out.println(resultDate ) ;
        }
    }
}