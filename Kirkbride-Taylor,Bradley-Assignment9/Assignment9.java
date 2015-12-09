// import ArrayList library so it can be used
import java.util.ArrayList ;

// import Collections Library so ArrayList can be sorted
import java.util.Collections ;


/**
 * Assignment9 - The purpose of this program is to add Employees to a payroll system. The Employees can be three different types and 
 * 		can work day or night shifts. The program also accumualtes total pay for each employee type and total payroll for all employees.
 * 
 * <pre>
 * Assignment 9
 * Course: ADEV-1003
 * Version: 1.0
 * Date Created: December 4, 2015
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
public class Assignment9
{
	/**
    * main - the purpose of this method is to run the program, it will mainly be calling other methods.
    * 
    * @param args - accepts command line arguments. Will not be utilized in this program.
    */
	public static void main (String[] args)
	{
		// The list of all employees on the payroll system
		ArrayList<Employee> employees ;

		// holds total salaries for each type of employee
		double[] totalSalaries = new double[3] ;
		
		// print the welcoming message
		AssignmentHelper.displayApplicationHeading("JavaBeans Manufacturing", "Payroll Application",'-') ;

		// Call method to add Employees to payroll system and return that list
		employees = addEmployees(totalSalaries) ;

		// sort the employees by id number in ascending order
		Collections.sort(employees) ;

		// print all the Employees on the payroll
		printEmployeePayroll(employees, totalSalaries) ;	
	}

	/**
    * addEmployees - Gets informations from user and creates Employee objects with that information. Adds 
    *		Employee objects to payroll list
    * 
    * @param totalSalaries - An array of total salaries for each type of postion at the company
	*
	* @return - An ArrayList of employees that have been added to the payroll.
    */
	private static ArrayList<Employee> addEmployees(double[] totalSalaries)
	{
		// used as a flag to see if user wants to continue adding employees
		boolean keepGoing ;

		// id number of the employee
		int id ;

		// shift code for time of day employee works
		int shift ;

		// What position the employee works
		int employeeType ;

		// The hours workded by the employee
		double hoursWorked ;

		// Rate of pay for an employee
		double rateOfPay ;

		// employees bonus amount
		double bonus ;

		// name of employee
		String name ;

		// Temporary Employee which is then added to payroll
		Employee employee ;

		// List of all Employees on payroll
		ArrayList<Employee> employees = new ArrayList<Employee>() ;

		// get information from the user to create Employees
		do
		{
			//Print a blank line for spacing
			System.out.println() ;

			// Theses Next four attributes are common to every employee
			// Get the id of the employee
			id = AssignmentHelper.getPositiveIntegerInput("Employee ID:", "Invalid employee ID!") ;

			// get the name of the employee
			name = AssignmentHelper.getStringInput("Employee name:","Invalid Employee Name!") ;

			// get shift that employee works
			shift = AssignmentHelper.getRangeInput("Shift (1-Day or 2-Night):","Invalid shift!", 1,2) ;

			// get the position the employee works
			employeeType = getEmployeeType() ;

			// if the employee is a production worker prompt for values
			if(employeeType == 1)
			{
				// get the hours worked
				// zero is a valid input
				hoursWorked = AssignmentHelper.getPositiveDoubleInput("Hours worked:","Invalid number of hours worked!",true) ;

				// get the rate of pay 
				// zero is not a valid input
				rateOfPay = AssignmentHelper.getPositiveDoubleInput("Rate of pay:","Invalid rate of pay!",false) ;
				
				// create a production workder object 
				employee = new ProductionWorker(name,id,shift,rateOfPay,hoursWorked) ;

				// add employee to payroll list
				employees.add(employee) ;
			}
			// if the employee is a Team Leader
			else if(employeeType == 2)
			{
				// get the hours worked
				// zero is a valid input
				hoursWorked = AssignmentHelper.getPositiveDoubleInput("Hours worked:","Invalid number of hours worked!",true) ;
				

				// get the rate of pay 
				// zero is not a valid input
				rateOfPay = AssignmentHelper.getPositiveDoubleInput("Rate of pay:","Invalid rate of pay!",false) ;
				

				// get monthly bonus amount
				// zero is a valid amount
				bonus = AssignmentHelper.getPositiveDoubleInput("Monthly bonus:","Invalid bonus amount!",true) ;

				// create TeamLeader object
				employee = new TeamLeader(name,id,shift,rateOfPay,hoursWorked,bonus) ;

				// add new Team Leader to the payroll
				employees.add(employee) ;
				

			}
			// must be a Shift Supervisor by process of elimination
			else
			{
				// get the annual salary amount
				// zero is not a valid response
				rateOfPay = AssignmentHelper.getPositiveDoubleInput("Annual salary:", "Invalid salary amount!", false) ;

				// get annual bonus amount
				bonus = AssignmentHelper.getPositiveDoubleInput("Annual bonus:","Invalid bonus amount!", false ) ;

				// create a new supervisor object
				employee = new ShiftSupervisor(name,id,shift,rateOfPay,bonus) ;

				// add supervisor to the payroll
				employees.add(employee) ;
			}

			// add the emplyee's salary to appropriate running total for position they work
			totalSalaries[employeeType -1] += employee.calculatePay() ;

			// print a spacer line
			System.out.println() ;

			// print out employee
			System.out.println(employee) ;

			// ask if user wants to keep adding employees
			keepGoing = AssignmentHelper.getYesOrNoResponse("Another employee? (y/n):","Invalid y/n reponse!") ;

		}
		// if true keep adding employees
		while(keepGoing) ;

		// print out a blank line
		System.out.println() ;

		// return the employee payroll list
		return employees ;
	}

	/**
	*	getEmployeeType - gets the position that the employee works
	*
	*	@return - the position that the employee works
	*/
	private static int getEmployeeType()
	{
		// employee type
		int type ;

		// prompt for the user
		String prompt = "Position (1, 2 or 3):" ;

		// error message for invalid input
		String error = "Invalid empoyee type!" ;

		// Print out options to the user
		System.out.println("\n1.Production Worker\n2.Team Leader\n3.Shift Supervisor\n") ;

		// get the type of employee from the user
		type = AssignmentHelper.getRangeInput(prompt,error,1,3) ;

		// print out spacer line
		System.out.println() ;

		// return the type of employee
		return type ;

	}

	/**
	*	printEmployeePayroll - prints all employees that are on the payroll and then 
	*
	*	@param - employees - ArrayList of all employees on the payroll
	*
	*	@param - totalSalaries - Total Salaries of all employees for each category 
	*/
	private static void printEmployeePayroll(ArrayList<Employee> employees, double[] totalSalaries)
	{
		// Print heading
		System.out.println("\nPayroll Report") ;

		// Print seperator 
		System.out.println("===============") ;
		
		// loop through each employee on the list
		for(int i = 0 ; i < employees.size() ; i++)
		{
			// print out the employee
			System.out.println(employees.get(i)) ;
		}

		// Display header for the section
		AssignmentHelper.displaySectionTitle("Total Payroll by Position") ;

		// print out the total salary burden for Production Workers
		System.out.printf("Production Workers: $%,3.2f%n",totalSalaries[0]) ;

		// print out the total salary burden for Team Leaders
		System.out.printf("Team Leaders: $%,3.2f%n",totalSalaries[1]) ;

		// print out the total salary burden for Shift Supervisors
		System.out.printf("Shift Supervisor: $%,3.2f%n%n",totalSalaries[2]) ;

		// print out the total payroll of all employees combined
		System.out.printf("Total Payroll: $%,3.2f%n",totalSalaries[0] + totalSalaries[1] + totalSalaries[2]) ;
	}	
}
