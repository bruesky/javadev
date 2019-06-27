package TernaryAssociation;

class Deal
{
	private static int currentNumber = 1;
	private static int getNextNumber() { return currentNumber++; }

	private int number;

	private Customer customer;
	private Product product;
	private SalesConsultant salesConsultant;
	// TODO: Implement ternary association ends
	
	
	public Deal(Product product,Customer customer, SalesConsultant salesConsultant)
	{
		number = getNextNumber();
		
		// TODO: Instantiate ternary association
		this.product = product;
		this.customer = customer;
		this.salesConsultant = salesConsultant;
		product.addDeal(this);
		customer.addDeal(this);
		salesConsultant.addDeal(this);
		
	}

	public int getNumber() { return number; }
	
	public void show()
	{
		System.out.println("Deal #" + number + ": ");
		
		// TODO: Print out name of each related object
		System.out.println("Product "+ ": "+product.getName());

		System.out.println("Customer " + ": "+customer.getName());

		System.out.println("Sales Consultant "+": "+salesConsultant.getName());




		System.out.println();
	}
}
