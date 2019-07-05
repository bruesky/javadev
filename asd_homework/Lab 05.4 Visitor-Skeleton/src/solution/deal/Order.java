package solution.deal;

import solution.visitors.Visitor;

public class Order extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager;}

	private String paymentTerms;	// Customer's payment terms
	private double price;			// What the customer will pay
	private double discount;		// Discount % offered to the customer
	private int quantity;			// Quantity ordered
	
	private Event event;			// Event that generated this Order
	private Terms terms;			// Vendor Terms
	private CompTerms compTerms;	// Salesperson's compensation terms active
									//   at the time of the order

	public Order(double price, double discount, int quantity,
			String paymentTerms, CompTerms compTerms)
	{
		manager.addObject(this);

		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.paymentTerms = paymentTerms;

		this.compTerms = compTerms;
	}

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	public double getDiscount() { return discount; }
	public void setDiscount(double discount) { this.discount = discount; }

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }

	public String getPaymentTerms() { return paymentTerms; }
	public void setPaymentTerms(String paymentTerms)
	{
		this.paymentTerms = paymentTerms;
	}

	public Terms getTerms() { return terms; }
	public void setTerms(Terms terms) { this.terms = terms; }

	public CompTerms getCompTerms() { return compTerms; }
	public void setCompTerms(CompTerms compTerms) { this.compTerms = compTerms; }

	public void setTerms(Terms terms, CompTerms compTerms)
	{
		this.terms = terms;
		this.compTerms = compTerms;
	}

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
    
    @Override
	public String toString()
	{
	    return "Order price: " + price + " quantity: " + quantity +
	    	   " discount: " + discount + " profit: " + getProfit();
	}

	public double getProfit()
	{
		double profit = 0;

		double orderGain = (price * discount - terms.getPrice()) * quantity;
		profit = orderGain - compTerms.getCommission(orderGain);

		return profit;
	}
	
	public void acceptVisitor(Visitor visitor)
	{
		visitor.execute(this);
	}
}