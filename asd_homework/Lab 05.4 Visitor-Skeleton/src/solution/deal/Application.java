package solution.deal;

import solution.visitors.ProfitVisitor;
import solution.visitors.TravelVisitor;
import solution.visitors.Visitor;

import java.util.Map;

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
			Visitor visitor = new TravelVisitor();
			SalesConsultant s = (SalesConsultant) o;
			s.acceptVisitor(visitor);
			System.out.println(s.getName());
			Map<String,Double> desAndcost = ((TravelVisitor)visitor).getDesAndCost();
			desAndcost.entrySet().stream().forEach(x->System.out.println(x.getKey()+" cost : "+x.getValue()));
			System.out.println("total travel cost :" + visitor.getState());
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		new Application();
	}
}
