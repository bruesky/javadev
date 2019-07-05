package solution.deal;

public class PhoneCall extends Event
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private double cost;

	public PhoneCall(String comments, String date, String mainAction, 
			String mainIssue, double cost)
	{
		super(comments, date, mainAction, mainIssue);
		
		manager.addObject(this);

		this.cost = cost;
	}

	@Override
	public double getCost() { return cost; }
	public void setCost(double cost) { this.cost = cost; }
}