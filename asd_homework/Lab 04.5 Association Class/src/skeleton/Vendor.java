package skeleton;

public class Vendor extends Company
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager; }	

	// TODO: Association class end

	public Vendor(String name, String address, String phone, String fax)
	{
		super(name, address, phone, fax);
		
		manager.addObject(this);
	}
	
	// TODO: add method
}