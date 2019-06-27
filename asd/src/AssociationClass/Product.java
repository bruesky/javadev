package AssociationClass;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Product extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager; }

	private String name;
	private String description;
	private List<Terms> termsList = new ArrayList<>();

	// TODO: Association class end

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

	// TODO: add methods
	void addTerms(Terms terms){
		this.termsList.add(terms);
	}

	/* Example for formatting a number as a Dollar amount:
	 * 
	 * 	double amount = 3000.0;
	 * 	NumberFormat nf = new DecimalFormat("$0.00");
	 * 	priceRange = "" + nf.format(amount);
	 */
	public String getPriceRange()
	{
		String priceRange;

		// TODO: return a string of low - high price range found in terms

		DoubleSummaryStatistics doubleSummaryStatistics=termsList.stream().collect(Collectors.summarizingDouble(terms->terms.getPrice()));

		priceRange = doubleSummaryStatistics.getMin()+" -- "+doubleSummaryStatistics.getMax();

		return priceRange;
	}

}
