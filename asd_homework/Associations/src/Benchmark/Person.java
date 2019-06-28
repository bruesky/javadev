package Benchmark;

public class Person
{
	String name;
	String ssn;
	

	public Person(String nm, String number)
	{
		name =  (nm != null) ? nm : "";
		ssn = (number != null) ? number : "";
	}

	public String toString()
	{
		String ret = new String();
		ret = "<" + name + ", " + ssn + ">";
		return ret;
	}
	
	public String getName() { return name; }
	public String getSSN() { return ssn; }
}
