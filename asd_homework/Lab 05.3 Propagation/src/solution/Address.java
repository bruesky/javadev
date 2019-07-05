package solution;

class Address extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private String street1;
	private String street2;
	private String city;
	private State state;
	private String zip;

	public Address(String street1, String street2, String city, State state,
			String zip)
	{
	    manager.addObject(this);

		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet1() { return street1; }
	public String getStreet2() { return street2; }
	public String getCity() { return city; }
	public State getState() { return state; }
	public String getZip() { return zip; }

	public void setStreet1(String street1) { this.street1 = street1; }
	public void setStreet2(String street2) { this.street2 = street2; }
	public void setCity(String city) { this.city = city;}
	public void setState(State state) { this.state = state; }
	public void setZip(String zip) { this.zip = zip; }
}
