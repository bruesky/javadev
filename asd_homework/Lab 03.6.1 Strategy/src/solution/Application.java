package solution;


public class Application
{
    public static void main(String[] args)
    {
        Order order = new Order(120, 220);
        Order order1 = new Order(700,300);

		EducationalDiscount educationalDiscount = new EducationalDiscount();
		GovernmentDiscount governmentDiscount = new GovernmentDiscount();
		CharitableDiscount charitableDiscount = new CharitableDiscount();
		MutilDiscount mutilDiscount = new MutilDiscount();
		mutilDiscount.addDiscountStrategy(educationalDiscount);
		mutilDiscount.addDiscountStrategy(governmentDiscount);
		mutilDiscount.addDiscountStrategy(charitableDiscount);

		// No discount first
		System.out.println(order.show());

		order.setDiscountStrategy(educationalDiscount);
		System.out.println(order.show());

		order.setDiscountStrategy(governmentDiscount);
		System.out.println(order.show());

		order.setDiscountStrategy(charitableDiscount);
		System.out.println(order.show());

		order1.setDiscountStrategy(mutilDiscount);
		System.out.println(order1.show());


		System.out.println();
    }
    
 }
