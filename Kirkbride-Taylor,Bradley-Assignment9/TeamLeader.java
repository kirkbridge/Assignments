/**
 * TeamLeader - Subclass of Employee 
 * 
 * <pre>
 * Assignment 9 - TeamLeader
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
public class TeamLeader extends ProductionWorker 
{
	// monthly bonus team leader
	private double monthlyBonus ;

	/**
	* TeamLeader - Constructor used to create Team Leader
	*
	* @param name - name of the supervisor
	* @param id - Employee ID of the supervisor
	* @param shift - the time of day the supervisor works (day = 1 and night = 2) 
	* @param rateOfPay - how much employee gets paid per hour
	* @param hoursWorked - how many hours they worked per week
	* @param monthlyBonus - The monthly bonus of the supervisor
	*/
	public TeamLeader(String name, int id, int shift, double rateOfPay, double hoursWorked, double monthlyBonus)
	{
		// send parameters to ProductionWorker and Employee constructors
		super(name,id,shift,rateOfPay,hoursWorked) ;

		// set monthly bonus value 
		this.monthlyBonus = monthlyBonus ;
	}

	/**
	* getMonthlyBonus - The monthly bonus the Team Leader recieves
	* 
	* @return - the monthly bonus 
	*/
	public double getMonthlyBonus()
	{
		// the monthly bonus
		return monthlyBonus ;
	}

	/**
	* setMonthlyBonus - Sets the monthly bonus 
	*
	* @param monthlyBonus - set the monthly bonus amount
	*/
	public void setMonthlyBonus(double monthlyBonus)
	{
		// set the monthly value 
		this.monthlyBonus = monthlyBonus ;
	}

	/**
	* calaculatePay - calculates the monthly pay ((hoursWorked * rateOfPay) + monthlyBonus)
	*
	* @return - monthly pay that the employee recieves
	*/
	public double calculatePay()
	{
		// Call super method to 
		return super.calculatePay() + monthlyBonus ;
	}

	/**
	* toString - convert the object into a representative String
	* 
	* @return - the String representation of the object
	*/
	public String toString()
	{
		// format Team Leader object into String 
		return String.format("Employee Id: %d Name: %s%nPosition: Team Leader%nShift: %d Hours: %2.1f ROP: $%3.2f Bonus: $%3.2f Pay: $%,3.2f%n",super.getId(), super.getName(), super.getShift(), super.getHoursWorked(),super.getRateOfPay(), monthlyBonus,calculatePay()) ;
	}
	
}