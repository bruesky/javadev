package skeleton.deal;

public class Meeting extends Event
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager;}	
	
	private double equipRent;
	private double foodCost;
	private double roomRental;
	private double teleConfCost;

	public Meeting(String comments, String date, String mainAction, 
			String mainIssue, double equipRent, double foodCost, 
			double roomRental, double teleConfCost)
	{
		super(comments, date, mainAction, mainIssue);
		
		manager.addObject(this);
		
		this.equipRent = equipRent;
		this.foodCost = foodCost;
		this.roomRental = roomRental;
		this.teleConfCost = teleConfCost;
	}

	public double getEquipRent() { return equipRent; }
	public void setEquipRent(double equipRent) { this.equipRent = equipRent; }

	public double getFoodCost() { return foodCost; }
	public void setFoodCost(double foodCost) { this.foodCost = foodCost; }

	public double getRoomRental() { return roomRental; }
	public void setRoomRental(double roomRental) { this.roomRental = roomRental; }

	public double getTeleConfCost() {return teleConfCost;}
	public void setTeleConfCost(double teleConfCost) 
	{ 
		this.teleConfCost = teleConfCost; 
	}

	@Override
	public double getCost()
	{
		return equipRent + foodCost + roomRental + teleConfCost;
	}	
}