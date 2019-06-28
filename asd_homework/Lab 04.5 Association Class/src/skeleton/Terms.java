package skeleton;

public class Terms extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager; }	

	private double price;
	private String delay;
	private String refund;

	// TODO: Association ends

	public Terms(Vendor vendor, Product product, double price, String delay, 
			String refund)
	{
		manager.addObject(this);
		
		this.price = price;
		this.delay = delay;
		this.refund = refund;

		// TODO: Create links between this link object and Vendor & Product
		
	}

	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	public String getDelay() { return delay; }
	public void setDelay(String delay) { this.delay = delay; }

	public String getRefund() { return refund; }
	public void setRefund(String refund) { this.refund = refund; }
}