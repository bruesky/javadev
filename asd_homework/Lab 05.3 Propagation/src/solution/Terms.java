package solution;

public class Terms extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private double price;
	private String delay;
	private String refund;

	private Product product;
	private Vendor vendor;

	public Terms(Vendor vendor, Product product, double price, String delay,
                 String refund)
	{
		manager.addObject(this);
		
		this.price = price;
		this.delay = delay;
		this.refund = refund;

		this.product = product;
		this.vendor = vendor;

		product.addTerms(this);
		vendor.addTerms(this);
	}

	public static void removeTerms(Terms term)
	{
		term.product.removeTerms(term);
		term.vendor.removeTerms(term);
		
		manager.delete(term);
	}

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	public String getDelay() { return delay; }
	public void setDelay(String delay) { this.delay = delay; }

	public String getRefund() { return refund; }
	public void setRefund(String refund) { this.refund = refund; }
	
	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }

	public Vendor getVendor() {return vendor;}
	public void setVendor(Vendor vendor) { this.vendor = vendor; }
}