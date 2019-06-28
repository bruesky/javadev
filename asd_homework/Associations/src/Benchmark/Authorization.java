package Benchmark;

public class Authorization
{
	private String date;
	private int level;
	
	public Authorization(String dt, int l)
	{
		date = dt;
		level = l;
	}

	public String toString()
	{
		String description = new String("<" + date + ", " + level + "> ");
		return description;
	}
	
	public String description() { return this.toString(); }
}

