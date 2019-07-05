package solution.deal;

public class State extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }
	
 	private String abbreviation;
 	private String name;

	public State(String abbreviation, String name)
	{
		manager.addObject(this);

		this.abbreviation = abbreviation;
		this.name = name;
	}

	public String getAbbreviation() {return abbreviation;}
	public void setAbbreviation(String abbreviation) 
	{ 
		this.abbreviation = abbreviation;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}
