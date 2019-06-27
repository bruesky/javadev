package TernaryAssociation;

import java.util.ArrayList;
import java.util.List;

class SalesConsultant
{
	private String name;
	private String phoneNumber;
	private List<Deal> deals = new ArrayList<>();

	public SalesConsultant(String nm, String ph)
	{
		name = nm;
		phoneNumber = ph;
	}
	
	public String getName() {return name;}
	public void setName(String str) {name = str;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String pn) {phoneNumber = pn;}

	public void addDeal(Deal deal){
		this.deals.add(deal);
	}
	
	public void show()
	{
		System.out.println("Sales Consultant: " + name);
		System.out.println("  Deals: "+deals.size());

		// TODO: Print each deal's number
		deals.forEach(deal -> System.out.print(deal.getNumber()+" "));


		System.out.println();
		System.out.println();
	}
}