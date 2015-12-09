import java.util.* ;
/**
 * Write a description of class Order here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Order
{
   private String customerName ;
   private ArrayList<LineItem> items ;//b ghttbhthhnewttuuy6njtyewryrtujtywr6ryhrtyhhywrwyrhthy6et5ythnwert5tw69;
   
   public Order(String customerName)
   {
       this.customerName = customerName ;
       items = new ArrayList<LineItem>() ;
   }
   
   public String getCustomerName()
   {
       return customerName ;
   }
   
   public ArrayList<LineItem> getItems()
   {
       return items ;
   }
   
   public double getOrderTotal()
   {
       return -1 ;
   }
   
   public void addItem( String description, double unitPrice, int quantity)
   {
       LineItem item = new LineItem(description, unitPrice, quantity) ;
       items.add(item) ;
   }
   
   public String toString()
   {
       String result ;
       
       result = "Customer:" + customerName +"\n\n" ;
       result += "ORDER ITEMS\n" ;
       result+= "--------------------------------------------------------------------------------\n" ;
       result+= String.format("%-48s%-10d%-,8.2f%014.2f\n","Item Description",000,0.0,0.0) ;
       for(int i =0 ; i < items.size() ; i++)
       {
           result += items.get(i).toString() ;
           
       }
       return result ; 
   }
}
