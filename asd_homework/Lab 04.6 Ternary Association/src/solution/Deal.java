package solution;

public class Deal
{
	private static int currentNumber = 1;
	private static int getNextNumber() { return currentNumber++; }

	private int number;
	
	private Customer customer;
	private SalesConsultant salesConsultant;
	private Product product;

	public Deal(Customer customer, SalesConsultant salesConsultant, 
			Product product)
	{
		number = getNextNumber();

		this.customer = customer;
		this.customer.addDeal(this);

		this.salesConsultant = salesConsultant;
		this.salesConsultant.addDeal(this);

		this.product = product;
		this.product.addDeal(this);
	}

	public int getNumber() { return number; }

	public Customer getCustomer() { return customer; }
	public SalesConsultant getSalesConsultant() { return salesConsultant; }
	public Product getProduct() { return product; }
	
	public void show()
	{
		System.out.println("Deal #" + number + ": ");
		System.out.println("  Product: " + product.getName());
		System.out.println("  Customer: " + customer.getName());
		System.out.println("  Sales Consultant: " + salesConsultant.getName());
		System.out.println();
	}
}
