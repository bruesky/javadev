package solution;

import java.time.LocalDate;
import java.util.Vector;

public abstract class Action extends MissionItem
{
	static private Vector<Action> instances = new Vector<>();
	static public Vector<Action> getInstances() {return instances;}
	
	private LocalDate startTime;	
	private LocalDate stopTime;	
	boolean completed = false;
	
	public Action(String nm, int num, String des)
	{
		super(nm, num, des);
		instances.add(this);
	}
	
	public void start() { startTime = LocalDate.now(); }
	public void stop() { stopTime = LocalDate.now(); }
	
	public void setCompleted() {completed = true;}
	public Boolean isCompleted() {return completed;}

	@Override
	public String getExtendedReport(String indentation)
	{
		return "Started at: " + startTime + ", Stopped at: " + stopTime + ((completed == true) ? ", completed" : ", incomplete") + "\n";	
	}
	
	public void hasBeenExecutedAs(Action theOtherAction) { Associations.actionHasBeenExecutedAsAnotherAction.link(this, theOtherAction);}

}
