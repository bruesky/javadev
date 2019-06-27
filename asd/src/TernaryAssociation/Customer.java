package TernaryAssociation;

import java.util.ArrayList;
import java.util.List;

class Customer
{
	private String name;
	private String contact;
	private String address;
	private String phone;
	private String fax;
	private List<Deal> deals = new ArrayList<>();
	
	public Customer(String name, String contact, String address, String phone, 
			String fax)
	{
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.phone = phone;
		this.fax = fax;		
	}
	
	public String getName() { return name; }
	public String getContact() { return contact; }
	public String getAddress() { return address; }
	public String getPhone() { return phone; }
	public String getFax() { return fax; }

	public void addDeal(Deal deal){
		this.deals.add(deal);
	}
	
	public void show()
	{
		System.out.println("Customer: " + name);
		System.out.println("  Deals: "+deals.size());

		// TODO: Print each deal's number
		deals.forEach(deal -> System.out.print(deal.getNumber()+" "));

		System.out.println();
	}
}
