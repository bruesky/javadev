package solution;

import java.util.ArrayList;
import java.util.List;

public class Group extends Product
{
	private List<Product> items = new ArrayList<Product>();

	public Group(int number, String name, String description)
	{
		super(number, name, description);
	}

	public void add(Product product)
	{
		items.add(product);
	}

	public int getPrice()
	{
		int price = 0;

		for (Product product : items)
			price += product.getPrice();

		return price;
	}

	public void show(String margin)
	{
		super.show(margin);

		System.out.println(margin + "       Items:");

		for (Product product : items)
		{
			product.show(margin + indent);
		}

		System.out.println();
	}
	
	// TODO: Implement clone()


	@Override
	protected Object clone() throws CloneNotSupportedException {
		Group group = new Group(getNumber(),getName(),getDescription());
		for (Product product : items)
			group.add((Product) (product.clone()));
		return group;
	}
}