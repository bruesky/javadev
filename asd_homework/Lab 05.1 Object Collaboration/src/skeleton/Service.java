package skeleton;

public class Service
{
	private String agent;
	private String date;
	private String requester;
	private String status;
	private String comments;

	public Service(String agent, String date, 
			String requester, String status, String comments)
	{
		this.agent = agent;
		this.date = date;
		this.requester = requester;
		this.status = status;
		this.comments = comments;
	}

	public String getServiceType() { return "Service"; }

	public void show()
	{
		System.out.println();
		System.out.println("Service Type: " + getServiceType());
		System.out.println("  Agent Name: " + agent);
		System.out.println("        Date: " + date);
		System.out.println("   Requester: " + requester);
		System.out.println("      Status: " + status);
		System.out.println("    Comments: " + comments);
	}
}