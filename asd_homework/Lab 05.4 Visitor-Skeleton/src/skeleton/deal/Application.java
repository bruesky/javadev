package skeleton.deal;

import skeleton.visitors.ProfitVisitor;
import skeleton.visitors.Visitor;

public class Application
{
	private Domain domain;
	private UI ui;

	public Application()
	{
		domain = new Domain();
		// ui = new UI(); //UI not needed in this lab

		for (Object o : Product.getManager().getAll())
		{
			Product p = (Product) o;
			Visitor v = new ProfitVisitor();
			p.acceptVisitor(v);
			System.out.printf("%-20s profit: %8.5f\n", p.getName(), v.getState());
		}

		System.out.println("\n");
		
		for (Object o : SalesConsultant.getManager().getAll())
		{
			SalesConsultant s = (SalesConsultant) o;
			
			// TODO: invoke travel visitor
			
			System.out.println(s.getName());
			
			// TODO: Print out travels (Extra Credit)
			
			// TODO: Print out total travel cost
		}
	}

	public static void main(String args[])
	{
		new Application();
	}
}
