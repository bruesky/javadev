package solution.visitors;

import solution.deal.*;

public abstract class Visitor
{
	public void execute(Product product) {}
	public void execute(Deal deal) {}
	public void execute(Event event) {}
	public void execute(Order order) {}
	public void execute(SalesConsultant salesConsultant) {}
	public void execute(Customer customer) {}
	public abstract Object getState();
}
