/**
 * ShiftSupervisor- Extends the Employee class. Used to create supervisors who are paid 
 *			a annual salary and recieve an annual bonus. Overides Calculate Pay as required.
 * 
 * <pre>
 * Assignment 9 - ShiftSupervisor
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
public class ShiftSupervisor extends Employee 
{
	// ANNUAL salary of supervisor
	private double salary ;

	// ANNUAL bonus of supervisor
	private double annualBonus ;
	
	/**
	* ShiftSupervisor - Constructor used to create Shift supervisors
	*
	* @param name - name of the supervisor
	* @param id - Employee ID of the supervisor
	* @param shift - the time of day the supervisor works (day = 1 and night = 2) 
	* @param salary - the ANNUAL salary of the supervisor
	* @param annualBonus - The annual bonus of the supervisor
	*/
	public ShiftSupervisor(String name, int id, int shift, double salary, double annualBonus)
	{
		// call Employee constuctor
		super(name,id,shift) ;

		// salary of the Supervisor
		this.salary = salary ;

		// Annual bonus of Supervisor
		this.annualBonus = annualBonus ;
	}

	/**
	* getSalary - return the salary of supervisor
	*
	* @return - the salary of supervisor
	*/
	public double getSalary()
	{
		// the salary of the supervisor
		return salary ;
	}

	/**
	* getAnnualBonus - 
	*
	*
	*/
	public double getAnnualBonus()
	{
		return annualBonus ;
	}

	public void setSalary(double salary)
	{
		this.salary = salary ;
	}

	public void setAnnualBonus(double annualBonus)
	{
		this.annualBonus = annualBonus ;
	}

	public double calculatePay()
	{
		return (salary + annualBonus) / 12 ;
	}

	/**
	* toString - convert the object into a representative String
	* 
	* @return - the String representation of the object
	*/
	public String toString()
	{
		return super.toString() + String.format("Position: Shift Supervisor%nShift: %d Salary: $%,3.2f Bonus: $%,3.2f Pay: $%,3.2f%n",super.getShift(), salary,annualBonus,calculatePay()) ;
	}
}