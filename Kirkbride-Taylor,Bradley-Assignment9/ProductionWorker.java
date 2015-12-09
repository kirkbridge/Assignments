/**
 * ProductionWorker - Subclass of Employee
 * 
 * <pre>
 * Assignment 9 - ProductionWorker
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
public class ProductionWorker extends Employee 
{
	// holds the rateOfPay
	private double rateOfPay ;

	// holds the hours worked that month
	private double hoursWorked ;

	public ProductionWorker(String name, int id, int shift, double rateOfPay, double hoursWorked)
	{
		super(name,id,shift) ;

		this.rateOfPay = rateOfPay ;

		this.hoursWorked = hoursWorked ;
		
	}

	public double getRateOfPay()
	{
		return rateOfPay ;
	}

	public double getHoursWorked()
	{
		return hoursWorked ;
	}

	public void setRateOfPay(double rateOfPay)
	{
		this.rateOfPay = rateOfPay ;
	}

	public void setHoursWorked(double hoursWorked)
	{
		this.hoursWorked = hoursWorked ;
	}

	public double calculatePay()
	{
		double pay ;

		if(super.getShift() == 2)
		{
			pay = (rateOfPay *1.5) * hoursWorked ;
		}
		else
		{
			pay = rateOfPay * hoursWorked ;
		}

		return pay ;
	}

	/**
	* toString - convert the object into a representative String
	* 
	* @return - the String representation of the object
	*/
	public String toString()
	{
		return super.toString() + String.format("Position: Production Worker%nShift: %d Hours: %2.1f ROP: $%,3.2f Pay: $%,3.2f%n",super.getShift(), hoursWorked, rateOfPay, calculatePay()) ;
	}

}