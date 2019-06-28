package solution;

import java.util.ArrayList;
import java.util.List;

public class SalesConsultant 
{
	private String name;
	private String phone;
	
	private List<Deal> deals = new ArrayList<Deal>();

	public SalesConsultant(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public void addDeal(Deal deal) { deals.add(deal); }
	public List<Deal> getDeals() { return deals; }
	
	public void show()
	{
		System.out.println("Sales Consultant: " + name);
		System.out.println("  Deals: " + deals.size());
		System.out.print("    ");
		for (Deal deal : deals)
			System.out.print(deal.getNumber() + " ");
		System.out.println();
		System.out.println();
	}
}