package skeleton.deal;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends Company
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager; }	

	private List<Terms> terms = new ArrayList<Terms>();

	public Vendor(String name, Address address, String phone, String fax)
	{
		super(name, address, phone, fax);
		
		manager.addObject(this);
	}
	
	public void addTerms(Terms term) { terms.add(term); }
	public void removeTerms(Terms term) { terms.remove(term); }
}