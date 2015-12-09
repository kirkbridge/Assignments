
/**
 * Write a description of class MaterialOrder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaterialOrder extends Order
{
    private double deliveryCharge ;
    
    public MaterialOrder(String customerName) 
    {
        this(customerName,-1.0) ;
    }
    public MaterialOrder(String customerName, double deliveryCharge)
    {
        super(customerName) ;
        this.deliveryCharge = deliveryCharge ;
    }
    
    public double getDeliveryCharge()
    {
        return deliveryCharge ;
    }
    
    public void setDeliveryCharge(double deliveryCharge)
    {
        this.deliveryCharge = deliveryCharge ;
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
