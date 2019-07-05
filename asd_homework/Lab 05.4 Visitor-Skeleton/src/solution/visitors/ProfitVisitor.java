package solution.visitors;

import solution.deal.*;
import solution.visitors.Visitor;

public class ProfitVisitor extends Visitor
{
	private double profit = 0.0;

	public Double getState() { return profit; }

	public void execute(Product product)
	{
		for (Deal deal : product.getDeals())
			deal.acceptVisitor(this);
	}

	public void execute(SalesConsultant salesConsultant)
	{
		for (Deal deal : salesConsultant.getDeals())
			deal.acceptVisitor(this);
	}

	public void execute(Customer customer)
	{
		for (Deal deal : customer.getDeals())
			deal.acceptVisitor(this);
	}

	public void execute(Deal deal)
	{
		for (Event event : deal.getEvents())
			event.acceptVisitor(this);
	}

	public void execute(Event event)
	{
		for (Order order : event.getOrders())
			order.acceptVisitor(this);

		if (event.getTravel() != null)
			profit -= event.getTravel().getCost();

		profit -= event.getCost();
	}

	public void execute(Order order)
	{
		double orderGain = (order.getPrice() * order.getDiscount() - 
				order.getTerms().getPrice()) * order.getQuantity();
		
		orderGain -= order.getCompTerms().getCommission(orderGain);
		
		profit += orderGain;
	}
}
