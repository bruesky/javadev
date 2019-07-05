package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SalesConsultant extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private String name;
	private String phoneNumber;
	
	private CompTerms compTerms;
	private List<Deal> deals = new ArrayList<Deal>();

	public SalesConsultant(String nm, String ph)
	{
		manager.addObject(this);

		name = nm;
		phoneNumber = ph;
	}

	public String getName() {return name;}
	public void setName(String str) {name = str;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String pn) {phoneNumber = pn;}

	public void addDeal(Deal deal) { deals.add(deal); }
	public List<Deal> getDeals() { return deals; }

	public CompTerms getCompTerms() {return compTerms;}
	public void setCompTerms(CompTerms compTerms)
	{
		if (this.compTerms != null)
			compTerms.setPrevious(this.compTerms);
		this.compTerms = compTerms;
	}

	public void printTravelCost(String date){
		System.out.printf("%s\n    Total travel cost: %f\n",name,getTravelCost(date));
	}

	public double getTravelCost(String date){
		double cost = 0.0;
		for (Deal deal:
			 deals) {
			cost+=deal.getTravelCost(date);
		}
		return cost;
	}

}