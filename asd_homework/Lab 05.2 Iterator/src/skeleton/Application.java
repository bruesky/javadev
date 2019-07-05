package skeleton;

import java.util.Iterator;

public class Application
{
	public static void main(String[] args)
	{
		SimpleList list = new SimpleList();
		list.append("Barnes & Noble");
		list.append("Borders");
		list.append("Amazon");
		list.append("Bookpool");
		print(list);
		
/*		
		System.out.println("Removing 3rd element...");
		for (Iterator iterator = list.iterator(); iterator.hasNext();)
		{
			String str = (String) iterator.next();
			if (str.equals("Amazon"))
				iterator.remove();
		}
		print(list);
	

		System.out.println("Removing 1st element...");
		for (Iterator iterator = list.iterator(); iterator.hasNext();)
		{
			String str = (String) iterator.next();
			if (str.equals("Barnes & Noble"))
				iterator.remove();
		}

		print(list);
*/
	}
	
	public static void print(SimpleList list)
	{
		System.out.println("Number of elements: " + list.count());
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();)
			System.out.println(iterator.next());		
		
		System.out.println();
	}
}


