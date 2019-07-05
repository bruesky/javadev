package solution.deal;

import solution.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Company
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private Person contact;
	private List<Deal> deals = new ArrayList<Deal>();

	public Customer(String name, Address address, String phone, String fax,
                    String contactName, String contactPhone, String contactEmail)
	{
		super(name, address, phone, fax);
		manager.addObject(this);
		contact = new Person(contactName, contactPhone, contactEmail);
	}

	public Person getContact() { return contact; }
	public void setContact(Person contact) { this.contact = contact; }

	public List<Deal> getDeals() { return deals; }
	public void addDeal(Deal deal) { deals.add(deal); }

	public void acceptVisitor(Visitor visitor)
	{
		visitor.execute(this);
	}
}
