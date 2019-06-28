package skeleton;

public class Product
{
	private String name;
	private String description;

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
	
	public void show()
	{
		System.out.println("Product: " + name);
		System.out.println("  Deals: ");

		// TODO: Print each deal's number

		System.out.println();
		System.out.println();
	}
}
