package skeleton;

import java.util.List;
import java.util.Vector;

public class Scenario extends MissionItem
{
	private static List<Scenario> instances = new Vector<>();			// A container of all the instances from this class
	public static List<Scenario> getInstances() { return instances; }		// Simple access to the container of instances
	
	private boolean active = true;
	
	public Scenario(String nm, int num, String des, boolean act)
	{
		super(nm, num, des);
		instances.add(this);
		active = act;
	}

	@Override
	protected String getType()
	{
		return "Scenario";
	}
	
	public void addPlannedAction(Action action) { Associations.scenarioIsComposedOfPlannedActions.link(this, action); }
	public List<Action> plannedActions() { return Associations.scenarioIsComposedOfPlannedActions.leftToRights(this); }

	// public void isConsideredFor(Mission mission) // TODO}
	// public void isNotConsideredForMission(Mission mission) // TODO

	public void isRetainedFor(Mission mission) {
        Associations.scenarioIsRetainedForAMission.link(this, mission);}
	public void isNotRetainedFor(Mission mission) {
        Associations.scenarioIsRetainedForAMission.unlink(this, mission);}
	
	// public void addConfirmedAction(Action action) // TODO
	// public List<Action> confirmedActions() // TODO

	@Override
	public String getExtendedReport(String indentation)
	{
		StringBuilder extRep = new StringBuilder();
		
		extRep.append((active ? "Active" : "Innactive") + "\n");
		
		indentation += "\t\t";
		String nextLevelOfIndentation = new String(indentation + "\t");

		extRep.append(indentation + "Planned Actions:" + "\n");				// List the Actions that are a part of this Scenario, if any
		
		for (Action plannedAction : plannedActions())
			extRep.append(plannedAction.getReport(nextLevelOfIndentation));
		
		extRep.append(indentation + "Confirmed Actions:" + "\n");			// List the Actions that are a part of this Scenario, if any
		
		// TODO: show the confirmed actions
		
		extRep.append(indentation + (isCompleted() ? "Scenario completed" : "Scenario not completed") + "\n");

		return extRep.toString();
	}
	
	boolean isCompleted() // TODO
	{
		Boolean completed = false;											// Can't be completed if there are no Confirmed Actions
		// Get all the Confirmed Actions
		// If there are any...
		
		// Scenario is considered completed unless at least one of its actions is not
			
		// Go through each action
		// If one of them isn't completed
		// ...then Scenario isn't, and we're done looking at the actions
		return completed;			
	}

}
