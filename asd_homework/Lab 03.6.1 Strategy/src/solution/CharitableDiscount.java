package solution;

public class CharitableDiscount extends DiscountStrategy {
    @Override
    public String getName() { return "Charitable"; }

    @Override
    public double getDiscount(int quantity, double unitPrice)
    {
        double discount = 0.0;
        double baseprice = quantity*unitPrice;
        if (baseprice>100000||quantity>2000)
            return discount;
        else {
            if (0<baseprice&&baseprice<=1000)
                discount = 0.9;
            else if (1000<baseprice&&baseprice<=8500)
                discount = 0.8;
            else if (8500<baseprice&&baseprice<=50000)
                discount = 0.7;
            else
                discount = 0.5;
        }

        return discount;
    }
}
