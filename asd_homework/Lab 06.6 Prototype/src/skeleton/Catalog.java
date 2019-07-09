package skeleton;

import java.util.ArrayList;
import java.util.List;

public class Catalog
{
	private List<Product> catalog = new ArrayList<Product>();

	public void showAll()
	{
		for (Product product : catalog)
			product.show();
	}

	public void add(Product product)
	{
	    catalog.add(product);
	}
}