package TernaryAssociation;

import java.util.ArrayList;
import java.util.List;

public class Product
{
	private String name;
	private String description;
	private List<Deal> deals = new ArrayList<>();

	public Product(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String description)
	{
		this.description = description;
	}

	public void addDeal(Deal deal){
		this.deals.add(deal);
	}
	
	public void show()
	{
		System.out.println("Product: " + name);
		System.out.println("  Deals: "+deals.size());

		// TODO: Print each deal's number
		deals.forEach(deal -> System.out.print(deal.getNumber()+" "));


		System.out.println();
		System.out.println();
	}
}
