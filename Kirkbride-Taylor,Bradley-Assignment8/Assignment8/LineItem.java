
/**
 * Write a description of class LineItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineItem
{
    private String description ;
    private double costPerUnit ;
    private int quantity ;
    
    public LineItem(String description, double costPerUnit, int quantity)
    {
        this.description = description ;
        this.costPerUnit = costPerUnit ;
        this.quantity = quantity ;
    }
    
    public String getDescription()
    {
        return description ;
    }
    
    public double getPricePerUnit()
    {
        return costPerUnit ;
    }
    
    public int getQuantity()
    {
        return quantity ;
    }
    
    public double getTotalPrice()
    {
        return quantity * costPerUnit ;
    }
    
    public String toString()
    {
        String result ;
        for(int i = 0 ; i < 80 ; i++)
        {
            System.out.print(i%10) ;
        }
        System.out.println() ;
        result = String.format("%-48s%-10d%,-8.2f%,14.2f\n",description,quantity,costPerUnit,this.getTotalPrice()) ;
        //result = String.format("Description:%s\nCost/Unit:%.2f\nQuantity:%d\nTotalPrice%.2f",description,costPerUnit,quantity,this.getTotalPrice()) ;
        
        return result ;
                                
    }
}
