package solution;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Dictionary			// This class is NOT used yet
{
	static private HashMap<String, List> tables = new HashMap<>();
	
	private <T> List<T> getClassList(T object)
	{
		String className = object.getClass().getSimpleName();
		
		List<T> classList = tables.get(className);
		
		if (classList == null)
		{
			classList = new Vector<T>();
			tables.put(className, classList);
		}
		
		return classList;
	}
	
	public <T> void add(T object)
	{
		tables.get(object).add(object);
	}
	
}


