package skeleton;

class SalesConsultant 
{
	private String name;
	private String phoneNumber;

	public SalesConsultant(String nm, String ph)
	{
		name = nm;
		phoneNumber = ph;
	}
	
	public String getName() {return name;}
	public void setName(String str) {name = str;}

	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String pn) {phoneNumber = pn;}
	
	public void show()
	{
		System.out.println("Sales Consultant: " + name);
		System.out.println("  Deals: ");

		// TODO: Print each deal's number

		System.out.println();
		System.out.println();
	}
}