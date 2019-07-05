package solution;

public class Application
{
	public static void main(String[] args)
	{
        SimpleList list = new SimpleList();

        list.append(new Service("John", "6/4/2002", "Barbara", "pending",
				"Low priority"));
		list.append(new ComputerService("Max Arthur", "6/21/2002",
				"Peter Armstrong", "Solved", "Must meet manager", 
				"www.pancakes.com", "Network down"));
		list.insert(new BuildingService("Roger Glover", "6/03/2002",
				"Peter Armstrong", "Pending", "Urban Design request",
				"101 N Main", "Engineering", 4, 10034));
		
        System.out.println("\n\tList of Services\n");

        for (list.restart(); list.hasItem(); list.next())
        {
            ((Service) list.getItem()).show();
            System.out.println();
        }

        System.out.println("List has " + list.getCount() + " items.\n");
	}
}
