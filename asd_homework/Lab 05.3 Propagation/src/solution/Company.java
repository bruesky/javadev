package solution;

class Company extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private String name;
	private Address address;
	private String phone;
	private String fax;

	public Company(String name, Address address, String phone, String fax)
	{
	    manager.addObject(this);

		this.name = name;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public Address getAddress() { return address; }
	public void setAddress(Address address) { this.address = address; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	public String getFax() { return fax; }
	public void setFax(String fax) { this.fax = fax; }
}
