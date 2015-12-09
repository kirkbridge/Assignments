
import java.util.* ;
/**
 * Write a description of class Assignment8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment8
{
   public static void main(String[] args)
   {	
   		String name ;

   		char orderType ;

   		double charge ;

   		Order customerOrder ;

   		name = getName() ;

   		orderType = getOrderType() ;



   		charge = getChargeAmount(orderType) ;

   		if(orderType == 'S' || orderType == 's')
   		{
   			customerOrder = new ServiceOrder(name,charge) ;
   		}
   		else
   		{
   			customerOrder = new MaterialOrder(name,charge) ;
   		}

   		processOrderItems(customerOrder) ;

   		printOrderSummary(customerOrder) ;

   }

   private static String getName()
   {
   		String name ;
   		String prompt = "Please enter the customer's name:" ;
   		String error = "A customer name must be entered!" ;

   		name = AssignmentHelper.getRequiredStringInput(prompt,error) ;

   		return name ;
   }

   private static char getOrderType()
   {
   		char result ;

   		String prompt = "Select order type: " ;

   		String error = "Invalid option!" ;

   		String validCharacters = "MmSs" ;

   		System.out.println("\nM - MaterialOrder\nS - Service Order\n") ;

   		result = AssignmentHelper.getRequiredCharacterInput(prompt,validCharacters,error) ;

   		System.out.println() ;

   		return result ;
   }

   private static double getChargeAmount(char orderType)
   {
   		double charge ;

   		if(orderType == 'M' || orderType == 'm')
   		{
   			charge = AssignmentHelper.getRequiredNonNegativeDoubleInput("Please enter the delivery charge amount: ","A delivery charge must be entered!", "The delivery charge must be greater than or equal to zero!") ;
   		}
   		else
   		{
   			charge = AssignmentHelper.getRequiredNonNegativeDoubleInput("Please enter the visit charge amount: ","A visit charge must be entered!", "The visit charge must be greater than or equal to zero!") ;
   		}

   		System.out.println() ;

   		return charge ;
   }

   public static void processOrderItems(Order order)
   {

   		int numOfItems = 1 ;

   		char continueCode ;

   		String description = "" ;

   		double price = 0;

   		int quantity = 0 ;


   		do
   		{
   			System.out.printf("Item %d\n", numOfItems ) ;
   			System.out.println(AssignmentHelper.repeatCharacter('-',80)) ;

   			if(order instanceof MaterialOrder)
   			{
	   			description = AssignmentHelper.getRequiredStringInput("Product description: ","A description must be entered") ;

	   			price = AssignmentHelper.getRequiredPositiveDoubleInput("Unit price: ","A unit price must be entered!","The unit must be greater than zero!") ;

	   			quantity = AssignmentHelper.getRequiredPositiveIntegerInput("Quantity: ","A quantity must be entered!","The quantity must be greater than zero!") ;
   			}
   			else if(order instanceof ServiceOrder)
   			{
	   			description = AssignmentHelper.getRequiredStringInput("Service description: ","A description must be entered") ;

	   			price = AssignmentHelper.getRequiredPositiveDoubleInput("Hourly rate: ","A visit charge must be entered!","The visit charge must be greater than or equal to zero!") ;

	   			quantity = AssignmentHelper.getRequiredPositiveIntegerInput("Hours of service: ","The hours of service must be entered!","The hours of service must be greater than zero!") ;


   			}

	   		else
   			{
   				System.out.println("Error order must be more specific") ;
   			}
   			
   			order.addItem(description, price, quantity) ;


   			continueCode = AssignmentHelper.getRequiredCharacterInput("Another Item (y|n)?: ", "yYnN","Please enter y or n!") ; 
   			System.out.println() ;
   			numOfItems++ ;
   		}
   		while(continueCode == 'y' || continueCode == 'Y') ;

   	}

   	public static void printOrderSummary(Order order)
   	{
   		String header = AssignmentHelper.centerOutput("Princess Plumbing Services",80);
   		String spacer = AssignmentHelper.centerOutput(AssignmentHelper.repeatCharacter('*',26),80) ;

   		System.out.println(header) ;
   		
         System.out.println(spacer) ;
   		
         System.out.print(order) ;
   	}
 
}
