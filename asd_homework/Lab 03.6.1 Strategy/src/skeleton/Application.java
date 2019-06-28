package skeleton;

public class Application
{
    public static void main(String[] args)
    {
        Order order = new Order(120, 220);

    	EducationalDiscount educationalDiscount = new EducationalDiscount();
    	GovernmentDiscount governmentDiscount = new GovernmentDiscount();
         
    	// No discount first
        System.out.println(order.show());
        
    	order.setDiscountStrategy(educationalDiscount);
    	System.out.println(order.show());
        
    	order.setDiscountStrategy(governmentDiscount);
    	System.out.println(order.show());

    	System.out.println();
    }
    
 }
