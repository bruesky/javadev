package skeleton;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Product extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager; }

	private String name;
	private String description;

	private List<Terms> terms = new ArrayList<Terms>();
	private List<Deal> deals = new ArrayList<Deal>();

	public Product(String name, String description)
	{
		manager.addObject(this);
		
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

	public void addTerms(Terms term) { terms.add(term); }
	public void removeTerms(Terms term) { terms.remove(term); }

	public List<Deal> getDeals() { return deals; }
	public void addDeal(Deal deal) { deals.add(deal); }

	public String getPriceRange()
	{
		String priceRange;
		double min = 0;
		double max = 0;

		for (Terms term : terms)
		{
			double price = term.getPrice();
			max = price > max ? price : max;
			min = ( price < min  || min == 0) ? price : min;
		}

		NumberFormat nf = new DecimalFormat("$0.00");
		priceRange = "" + nf.format(min);

		if (min != max)
			priceRange += " - " + nf.format(max);

		return priceRange;
	}

	public double getProfitFor()
	{
		double profit = 0;
		
		// TODO: Implement profit analysis function

		return profit;
	}
}
