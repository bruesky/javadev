package skeleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Crew		// TO DO: to be completed
{
	private static List<Crew> instances = new ArrayList<>();		// A container of all the instances from this class
	public static List<Crew> getInstances() { return instances; }	// Simple access to the container of instances
	
	private String name;
	LocalDate creationDate = LocalDate.now();
	LocalDate dissolutionDate = null;								// Default is NO dissolution date.
	
	public Crew(String nm)
	{
		instances.add(this);
		name = nm;
	}
	
	public void setDissolutionDate(String dateText)
	{
		dissolutionDate = LocalDate.parse(dateText);
	}

	public String report(String indent)
	{
		return indent + "Crew: " + name + ", started on: " + creationDate + (dissolutionDate == null ? "" : (" dissolved on: " + dissolutionDate));
	}
	
	public String toString() { return report(""); }
}
