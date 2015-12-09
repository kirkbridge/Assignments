
/**
 * Write a description of class ServiceOrder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServiceOrder extends Order
{
    private double visitCharge ;
    
    public ServiceOrder(String customerName)
    {
        this(customerName,-1) ;
    }
    
    public ServiceOrder(String customerName, double visitCharge)
    {
        super(customerName) ;
        this.visitCharge = visitCharge ;
    }
    
    public double getVisitCharge()
    {
        return visitCharge ;
    }
    
    public void setVisitCharge(double visitCharge)
    {
        this.visitCharge = visitCharge ;
    }
    
    public double getOrderTotal()
    {
        return -1 ;
    }
    
    public String toString()
    {
        return "" ;
    }
}
