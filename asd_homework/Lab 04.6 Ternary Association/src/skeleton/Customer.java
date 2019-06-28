package skeleton;

class Customer 
{
	private String name;
	private String contact;
	private String address;
	private String phone;
	private String fax;
	
	public Customer(String name, String contact, String address, String phone, 
			String fax)
	{
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.phone = phone;
		this.fax = fax;		
	}
	
	public String getName() { return name; }
	public String getContact() { return contact; }
	public String getAddress() { return address; }
	public String getPhone() { return phone; }
	public String getFax() { return fax; }
	
	public void show()
	{
		System.out.println("Customer: " + name);
		System.out.println("  Deals: ");

		// TODO: Print each deal's number

		System.out.println();
	}
}
