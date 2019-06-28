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
		priceRange = "Your code is to show the price range.";

		return priceRange;
	}

}
