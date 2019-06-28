package Benchmark;

public 	class Project
{
	private String name;
	private int priority;
	
	public Project(String nm, int pr) {name = nm; priority = pr;}

	public String toString ()
	{
		String desc = new String("<" + name + ", " + priority + "> ");
		return desc;
	}
};

