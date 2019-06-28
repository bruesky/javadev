package solution;

public class Order
{
	private double price;
	private int quantity;
	private DiscountStrategy discountStrategy;

	public Order(double unitPrice, int quantity)
	{
		this.price = unitPrice;
		this.quantity = quantity;
	}

	public double getPrice() { return price; }

	public int getQuantity() { return quantity; }

	public void setDiscountStrategy(DiscountStrategy discountStrategy)
	{
		this.discountStrategy = discountStrategy;
	}

	public double getDiscountedPrice()
	{
		double discountedPrice = 0;		// Calculated price after discount is applied
		double discount = 0;			// Discount that apply for this order. None by default.

		if (discountStrategy != null)
			discount = discountStrategy.getDiscount(quantity, price);

		discountedPrice = quantity * price * (1 - discount);

		return discountedPrice;
	}

	public String getDiscountType()
	{
		String ret;

		if (discountStrategy != null)
			ret = new String(discountStrategy.getName());
		else
			ret = new String("No discount");

		return ret;
	}

	public String show()
	{
		StringBuilder descr = new StringBuilder();

		descr.append("Quantity: ").append(quantity).append(", Unit price: ").
				append(price).append(" = ").append(quantity*price).append(", with discount: ").
				append(getDiscountType()).append(":\t").append(getDiscountedPrice()).append("\n");

		return descr.toString();

	}
}
