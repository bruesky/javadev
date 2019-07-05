package solution.deal;

import solution.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Deal extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();
	public static ObjectManager getManager() { return manager;}	

	private static int currentNumber = 1;
	private static int getNextNumber() { return currentNumber++; }

	private int number;
	
	private Customer customer;
	private SalesConsultant salesConsultant;
	private Product product;
	private List<Event> events = new ArrayList<Event>();

	public Deal(Customer customer, SalesConsultant salesConsultant,
			Product product)
	{
		manager.addObject(this);

		number = getNextNumber();

		this.customer = customer;
		this.customer.addDeal(this);

		this.salesConsultant = salesConsultant;
		this.salesConsultant.addDeal(this);

		this.product = product;
		this.product.addDeal(this);
	}

	public int getNumber() { return number; }

	public Customer getCustomer() { return customer; }
	public SalesConsultant getSalesConsultant() { return salesConsultant; }
	public Product getProduct() { return product; }
	public List<Event> getEvents() { return events; }

	public Event getEventAt(int i)
	{
		return (Event) events.get(i);
	}
	
	public void addEvent(Event event) 
	{
	    events.add(event);
	    event.setDeal(this);
	}

	public void acceptVisitor(Visitor visitor)
	{
		visitor.execute(this);
	}
}
