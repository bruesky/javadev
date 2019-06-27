package AssociationClass;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends Company
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager; }
	private List<Terms> termsList = new ArrayList<>();

	// TODO: Association class end

	public Vendor(String name, String address, String phone, String fax)
	{
		super(name, address, phone, fax);
		
		manager.addObject(this);
	}
	
	// TODO: add method
	public void addTerms(Terms terms){
		this.termsList.add(terms);
	}
}