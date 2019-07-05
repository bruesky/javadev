package solution;

public class BuildingService extends Service
{
	private String address;
	private String department;
	private int floor;
	private int workOrder;

	public BuildingService(String agent, String date, 
			String requester, String status, String comments, String address, 
			String department, int floor, int workOrder)
	{
		super(agent, date, requester, status, comments);	
		
		this.address = address;
		this.department = department;
		this.floor = floor;
		this.workOrder = workOrder;
	}

	public String getServiceType() { return "Building Service"; }

	public void show()
	{
		super.show();									
		System.out.println("     Address: " + address);	
		System.out.println("  Department: " + department);
		System.out.println("       Floor: " + floor);
		System.out.println("  Work Order: " + workOrder);
	}
}