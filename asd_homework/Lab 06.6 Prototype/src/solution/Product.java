package solution;

public abstract class Product implements Cloneable
{
	// Indent used to create margins
	protected static final String indent = "              ";	

	private int number;
	private String name;
	private String description;

	public Product(int number, String name, String description)
	{
		this.number = number;
		this.name = name;
		this.description = description;
	}

	public int getNumber() { return number; }
	public String getName() { return name; }
	public String getDescription() { return description; }
	
	public void setName(String name) { this.name = name; }
	
	public abstract int getPrice();

	public void show()
	{
		show("");
	}
	
	public void show(String margin)
	{
		System.out.println(margin + "      Number: " + number);
		System.out.println(margin + "Product Name: " + name);
		System.out.println(margin + " Description: " + description);
		System.out.println(margin + "       Price: $" + getPrice());
		System.out.println();
	}
	
	// TODO: Implement Cloneable & clone() method


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}