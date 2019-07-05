package solution;

public class ComputerService extends Service
{
	private String domain;
	private String incident;

	public ComputerService(String agent, String date, 
			String requester, String status, String comments, String domain, 
			String incident)									
	{
		super(agent, date, requester, status, comments);		
		
		this.domain = domain; 
		this.incident = incident;		
	}

	public String getServiceType() { return "Computer Service"; }

	public void show()
	{
		super.show();									
		System.out.println("      Domain: " + domain);
		System.out.println("    Incident: " + incident);
	}
}

