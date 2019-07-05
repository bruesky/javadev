package solution;

import java.util.ArrayList;
import java.util.List;

class Event extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager; }	

	private String comments;
	private String date;
	private String mainAction;
	private String mainIssue;
	
	private Deal deal;
	private Travel travel;
	private List<Order> orders = new ArrayList<Order>();

	public Event(String comments, String date, String mainAction, 
			String mainIssue)
	{
		manager.addObject(this);

		this.comments = comments;
		this.date = date;
		this.mainAction = mainAction;
		this.mainIssue = mainIssue;
	}

	public String getComments() { return comments; }
	public void setComments(String comments) { this.comments = comments; }

	public String getDate() { return date;}
	public void setDate(String date) { this.date = date;}

	public String getMainAction() { return mainAction; }
	public void setMainAction(String mainAction) { this.mainAction = mainAction; }

	public String getMainIssue() { return mainIssue; }
	public void setMainIssue(String mainIssue) { this.mainIssue = mainIssue; }

    public Deal getDeal() { return deal; }
    public void setDeal(Deal deal) { this.deal = deal; }

	public double getCost()
	{
		return 0;
	}

	public Travel getTravel() { return travel; }
	public void setTravel(Travel tr) {travel = tr;}

	public List<Order> getOrders() { return orders; }

	public void addOrder(Order order)
	{
		orders.add(order);
		order.setEvent(this);
	}

	public void removeOrder(Order order) { orders.remove(order); }

	public double getTravelCost(String date){
		double cost = 0.0;
		if (travel!=null)
			cost = travel.getCost();
		 return cost;
	}
}