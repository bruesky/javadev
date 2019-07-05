package solution;

public class CharitableDiscount extends DiscountStrategy
{
	public String getName() { return "Charity"; }
	
    public double getDiscount(int quantity, double price)
    {
    	double discount = 0;
    	double basePrice = quantity * price;

    	if (quantity > 2000 || basePrice > 100000)
    		discount = 0;
    	else if (basePrice > 50000)
    		discount = .50;
    	else if (basePrice > 8500)
    		discount = .70;
    	else if (basePrice > 1000)
    		discount = .80;
    	else if (basePrice > 0)
    		discount = .90;

    	return discount;
    }

}
