
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
       LineItem item = new LineItem("hammer",20,1000) ;
       Order order = new Order("Brad") ;
       order.addItem("hammer",20,1000) ;
       System.out.println(item) ;
       System.out.println(order) ;
   }
}
