package skeleton;

/**
 * Superclass for all types of companies.
 */
public class Company
{
	private String name;
	private String address;
	private String phone;
	private String fax;

	public Company(String name, String address, String phone, String fax)		
	{
		this.name = name; 
		this.address = address; 
		this.phone = phone; 
		this.fax = fax;
	}

	public void setName(String name) { this.name = name; }
	public String getName() { return name; }

	public void setAddress(String address) { this.address = address; }
	public String getAddress() { return address; }

	public void setPhone(String phone) { this.phone = phone; }
	public String getPhone() { return phone; }
	
	public void setFax(String fax) { this.fax = fax; }
	public String getFax() { return fax; }

	public String getType() { return "Company"; }

	public void show()
	{
		System.out.println();
		System.out.println(" Company Name: " + name);
		System.out.println("         Type: " + getType());
		System.out.println("      Address: " + address);
		System.out.println("        Phone: " + phone);
		System.out.println("          Fax: " + fax);
	}
}
