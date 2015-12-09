// Imports that required library to use Scanner
import java.util.Scanner ;

/**
 * ShippingContainer - The purpose of this program is to calcualte the ideal set of containers
 * to use to ship gps units. The program asks for a number of gps to be shipped and the program 
 * outputs the most optimized configuration of containers to use.
 * 
 * <pre>
 * Assignment
 * Course: ADEV-1003
 * Version: 1.0
 * Date Created: November 3, 2015
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
public class ShippingContainers
{
    // an integer array of how many items a box can hold
    final static int[] BOXES_SIZES = {50,20,5,1} ;

    // the coresponding parallel array of BOXES_SIZES,
    // holds the label for the box size
    final static String[] BOX_TYPES ={"XL","L","M","S"} ;
     
     
   /**
    * main - the purpose of this method is to run the program, it will mainly be calling other methods.
    * 
    * @param args - accepts command line arguments. Will not be utilized in this program.
    */
   public static void main(String[] args)
   {
        // an object used to capture input from the keyboard
        Scanner input  = new Scanner(System.in) ;

        // how many orders to be entered
        int howManyOrders ;

        // an array of businesses' names
        String[] businesses ;

        // a multi-dimensional array of shipments
        int[][] shipments ;

        // print the welcome headings
        printHeader() ;

        // how many orders is the user going to process
        howManyOrders = howManyShipments(input) ;

        //initalize the array to store the business names
        businesses = new String[howManyOrders] ;

        // intialzie the array to store the shipments
        shipments = new int[howManyOrders][BOXES_SIZES.length] ;

        // process all the orders to be shipped
        processOrders(input,businesses,shipments,howManyOrders) ;

        // print the report
        printReport(shipments,businesses) ;
    }

   /**
   * processOrders - This method will loop until all the orders are processed. It will call the method to get
   *  the names entered for buisnesses as well process how many boxes will be used for their order.
   *
   * @param input - This is a scanner object used to get input from the keyboard
   * @param businessess - This is a string array that will contain
   * @param shipments - This is a multidimensional area the contains the shipment in the first array and the boxes
   *    that are need in the second dimesion of the array.
   * @param orders - This is how many orders the user wants to process.
   *
   */
   private static void processOrders(Scanner input,String[] businesses, int[][] shipments, int orders)
   {
        // how many items in for the shipment 
        int items ;

        // loop until all the orders are processed
        for(int i = 0 ; i < orders ; i++)
        {
            // call method to get the name of the business
            // store that in the array of business names
            businesses[i] = getName(input) ;

            // how many items the user wants to ship
            items = howManyItems(input) ;

            // caclulate how many boxes are required
            calculateBoxes(shipments[i], items) ;

            // print the boxes that are needed
            printBoxes(shipments[i]) ;
        }

   }

   /**
   *  howManyShipments - This method is used to prompt the user for how many shipments the user would like to enter.
   *  
   * @param input - This is a scanner object used to get input from the keyboard
   * 
   * @return shipments - How many orders the user want to process this session
   */
   private static int howManyShipments(Scanner input)
   {
        // how many shipments the user wants to enter
        int shipments;
       
     
        do
        {
            // Print how many shipments to enter
            System.out.print("How many shipments to enter? ") ;

            // get the shipments from user and parse it into an int
            shipments = Integer.parseInt(input.nextLine()) ;

            // check to see if shipments are less than 1
            if(shipments < 1)
            {
                // Print out error 
                System.out.println("\n**Error** - Invalid number of shipments\n") ;

   
            }
         
        }
        // keep looping till user enters a valid value
        while(shipments < 1) ;
       
        // return the number of shipments the user is going to enter
        return shipments ;
   }
   
   /**
   * getName - This method is used to prompt the user for the business name for the shipment that is
   *      going to be processed.
   *
   * @param input - This is a scanner object used to get input from the keyboard
   *
   * @return name - The name of the business entered by the user
   */
   private static String getName(Scanner input)
   {
       // used to store the name entered by the user
       String name ;

       // flag used if input is valid or not
       boolean isValid = false ;
       
       // Get the business from the user
       do
       {
            // print the business name
            System.out.print("\nBusiness Name: ") ;

            // get the name from the user and remove leading and trailing white space
            name = input.nextLine().trim() ;

            // check to see if the length of name is zero
            if(name.length() == 0) 
            {
                // print the error message
                System.out.println("\n**Error** - Name is required") ; 

                // set the flag to false as error occured
                isValid = false ;
            }
            // name entered is valid
            else
                // set the flag to true
                isValid = true ;
           
           
           
       }
       // keep looping until valid name is entered
       while(!isValid) ;
       
       // return the name entered by the user
       return name ;
   }
   
   /**
   * howManyItems - This method will prompt the user for how many items will need to be processed for the 
   *  current order.
   *
   * @param input - This is a scanner object used to get input from the keyboard
   * 
   * @return items - How many items will be in the order
   */
   private static int howManyItems(Scanner input)
   {
        // holds how many items need to be shipped
        int items ;

        // Get how many items need to be shipped
        do
        {
            // print prompt for user to enter how many items need to be shipped
            System.out.print("\nEnter the number of GPS receivers to ship: ") ;

            // convert user's response into an integer
            items = Integer.parseInt(input.nextLine()) ;
           
           
            // check to see if items are less than 1
            if(items < 1)
                // print the error message 
                System.out.println("\n**Error** - Number of GPS receivers must be greater than zero") ; 
       }
       // keep looping until response is greater than 1
       while(items < 1) ;
       
       // return the number of items to be shipped
       return items ;
   }
   
   /**
   * calculateBoxes - this method will calculate how many boxes will be need to ship all the 
   *  items for the current order.
   *
   * @param shipment- This is an array that will hold how many boxes will be needed. The array 
   *      has as many elements in it as there are different box types.
   * @param items - How many items need to be shipped for this order.
   *
   */
   private static void calculateBoxes(int[] shipment, int items)
   {
       
       // used to keep track of remaing items that still need boxes
       int leftover = 0;
       
       // loop until all items are in boxes 
       for(int i = 0 ; i < shipment.length ; i++)
       {
            // calculate how many of this type of box
            // are required  for this shipment
            shipment[i] = items /BOXES_SIZES[i] ;

            // calculate how many remaining items that
            // need to be put in smaller boxes
            leftover = items % BOXES_SIZES[i] ;

            // set items that need to be put in boxes
            // to the number of remaining items
            items = leftover ;
        }
   }
   
   /**
   * printBoxes - This method will loop through each element of the area and print out how many boxes are needed
   *
   * @param box -this is the array that is filled with how many boxes are needed. It is ordered by size of box
   *        from largest to smallest.
   *
   */
   private static void printBoxes(int[] box)
   {
        // print message to consle
        System.out.println("\nBoxes Required\n") ;

        // loop until all elements in box array are printed
        for( int i = 0 ; i < BOXES_SIZES.length ; i++)
        {
            // print the label for box type and how many boxes required
            // for that particular box type
            System.out.printf("%-2s - %d\n",BOX_TYPES[i],box[i]) ;
        }
   }

   /**
   * printHeader - Print out the intital header of the program. 
   *
   */
   private static void printHeader()
   {
        // print the Name of the company of inventory software
        System.out.println("Red River Electronics") ;

        // print what the software is used for
        System.out.println("Shipping System") ;

        // print spacer line
        System.out.println("---------------------") ;
   }
   
   /**
   * printReport - This method will print the final end report. It will print out the businesses' names  
   *      as well as how many boxes there items will require. This method also calculates the total number
   *      of boxes needed to fufill all the orders entered. It will then print out those totals.
   *
   * @param shipments - Multi-dimensional array that has all the shipments and how many boxes are need for each shipment
   * @param businessess - This is a string array that contains the names of all the businesses
   *
   */
   private static void printReport(int[][] shipments, String[] businesses)
   {
        // array to store the total box count for all order combined
        int totalContainers[] = new int[BOXES_SIZES.length] ;

        // Print Summary to consle
        System.out.println("\nSummary") ;

        //Print spacer to consle
        System.out.println("---------") ;

        // loop until all orders processed are printed
        for(int i = 0 ; i < businesses.length ; i ++)
        {
            // print the shipment number and which business ordered the shipment
            System.out.printf("Shipment #%d - %s\n",i + 1,businesses[i]) ;

            // Loop until all elements of the shipment array have been printed
            for( int j = 0 ; j < BOXES_SIZES.length ; j++)
            {
                // if this the last element of the array to be printed
                // dont print a comma after and print 2 blank lines
                if(j == (BOXES_SIZES.length -1))
                {
                    // print type of box and how many of those boxes are needed, 
                    // no comma after the elements are printed
                    System.out.printf("%s - %d\n\n",BOX_TYPES[j],shipments[i][j]) ;
                }
                // if it is any element besides the last element
                else
                    // print type of box and how many of those boxes are needed
                    // followed by a comma
                    System.out.printf("%s - %d, ",BOX_TYPES[j],shipments[i][j]) ;

                // calculate the total amount of boxes need for each type
                totalContainers[j] += shipments[i][j] ;
            }
                                                             
        }

        // Print out Total number of containers required for these shipments
        System.out.println("Total Number of containers required for these shipments:") ;
        
        // loop until every element in totalContainers is printed
        for( int i = 0 ; i < BOXES_SIZES.length ; i++) 
        {
            // print the box type label and how many of those boxes used
            // to fufill all shipping orders
            System.out.printf("%-2s - %d\n",BOX_TYPES[i],totalContainers[i]) ;
        }
    }
}
