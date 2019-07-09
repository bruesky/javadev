package solution;

public class ProductItem extends Product
{
	private int price;

	public ProductItem(int number, String name, String description, int price)
	{
		super(number, name, description);
		this.price = price;
	}

	public int getPrice()
	{
		return price;
	}
	
	// TODO: Implement clone()


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new ProductItem(getNumber(),getName(),getDescription(),price);
	}
}