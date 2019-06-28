package Benchmark;
import java.util.Map;
import java.util.HashMap;

public class Account 
{
	private static Map<Integer, Account> accounts = new HashMap<Integer, Account>();

	private Integer id;
	private String name;

	public static Account getAccount(Integer key)
	{
		Account ret = accounts.get(key);
		return ret;
	};

	public Account(Integer identification, String nm)
	{
		id = identification;
		name = nm;
		accounts.put(identification, this);
	}
	
	public String description()
	{
		String descr = new String();
		
		descr = "<" + id + "," + name + ">";

		return descr;
	}
	
	public String toString()
	{
		return description();
	}
	
	public int getId() { return id; }
	
	public static String report()				// This is just for fun
	{
		String rep = new String();
		
		java.util.Collection<Account> collection = accounts.values();
		for (Account account : collection)
			rep += account.description() + " ";
		
		return rep;
	}
}
