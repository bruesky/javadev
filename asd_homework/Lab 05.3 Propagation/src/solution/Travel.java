package solution;

class Travel extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }

	private double airfare;
	private double car;
	private double taxi;
	private String destination;

	public Travel(double airfare, double car, double taxi, String destination)
	{
		manager.addObject(this);

		this.airfare = airfare;
		this.car = car;
		this.taxi = taxi;
		this.destination = destination;
	}

	public double getAirfare(){ return airfare; }
	public void setAirfare(double airfare) { this.airfare = airfare; }

	public double getCar(){ return car; }
	public void setCar(double car) { this.car = car; }

	public double getTaxi(){ return taxi; }
	public void setTaxi(double taxi) { this.taxi = taxi; }

	public String getDestination() { return destination; }
	public void setDestination(String destination) 
	{ 
		this.destination = destination; 
	}

	public double getCost()
	{
		return airfare + car + taxi;
	}
}