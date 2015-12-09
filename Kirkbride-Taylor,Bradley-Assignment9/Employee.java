/**
 * Employee - Class for Employees. This is an abstract class so there will be no instances of this class. It is used to 
 * 		define the methods that other classes will be using. Also holds common properties and methods of all child classes of 
 *		employee.
 * 
 * <pre>
 * Assignment 9 - Employee
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

public abstract class Employee implements Comparable<Employee>
{
	// name of the employee
	private String name ;

	// ID of the employee
	private int id ;

	// shift of employee (day or night)
	private int shift ;

	/**
	* Employee - constructor for Employee class
	*
	* @param name - the name of the employee
	* @param id - the ID of the employee
	* @param shift - the shift of the employee (can be day = 1 or night =2)
	*/
	public Employee(String name, int id, int shift)
	{
		// set name to name passed in
		this.name = name ;

		// set ID to ID that was passed in
		this.id = id ;

		// set shift to shift that was passed in
		this.shift = shift ;
	}

	/**
	* getName - returns the name of the employee
	*
	* @return - the name of the employee
	*/
	public String getName()
	{
		// return the name of the employee
		return this.name ;
	}

	/**
	* getId - returns the ID number of the employee
	*
	* @return - the id of the employee
	*/
	public int getId()
	{
		// return employee id
		return id ;
	}

	/**
	* getShift - returns the shift the Employee works ( day = 1 and night = 2)
	*
	* @return - shift that employee works
	*/
	public int getShift()
	{
		// return the shift 
		return shift ;
	}

	/**
	* compareTo - Compares two different employee objects by their respective Employee ID's.
	*		This implements the compareTo method from the Comparable interface. If the employee object who called
	*		the method is smaller than the one it is comparing then a 1 is returned, if it is greater then a -1 is returned
	*		if equal a 0 is returned.
	*
	* @return - The resulting integer based on the comparison.
	*/
	public int compareTo(Employee e)
	{
		// value to be returned
		int result = 0 ;

		// check to see if the item that is being compared to is bigger
		if(this.id < e.getId())
		{
			// if other item is bigger then result should be negative
			result = -1 ;
		}
		// check to see if the item that is being compared to is smaller
		else if(this.id > e.getId() )
		{
			// if other item is smaller then result should be positive
			result = 1 ;
		}
		// if its not bigger or smaller then the ids must be equal
		else
		{
			// if the other ID is the same then they are equal
			result = 0 ;
		}

		// return the result
		return result  ;
	}

	// abstract method that must be overidden by Child classes
	public abstract double calculatePay() ;

	/**
	* toString - convert the object into a representative String
	* 
	* @return - the String representation of the object
	*/
	public String toString()
	{
		// Basic String representaion of Employee objects
		return String.format("Employee ID: %d Name: %s%n",id,name) ;
	}
}