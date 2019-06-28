package skeleton;

import Framework.*;

public class Associations
{
	static public Association.Multiplicity ZeroOrMore = Association.Multiplicity.ZeroOrMore;
	static public Association.Multiplicity ZeroOrOne = Association.Multiplicity.ZeroOrOne;
	
	static public OneToOne<Scenario, Mission> scenarioIsRetainedForAMission = new OneToOne<>("Is Retained For", "Has Retained", "Designated Plan", "Mission");
	static public OneToOne<Scenario, Mission> scenarioHappenedDuringAMission = new OneToOne<>("Happened During", "Executed", "Actual Scenario", "Mission");
	// TO DO: Scenarios that are considered for Missions 
	static public ManyToOne<Mission, Crew> missionIsCarriedOutByACrew = new ManyToOne<>("Is Carried Out By", "Carries Out", "Mission", "Mission Crew");
	static public OneToMany<Scenario, Action> scenarioIsComposedOfPlannedActions = new OneToMany<>("Is Composed", "Is Planned For", "Planned Scenario", "Planned Action");
	// TO DO: the aggregation of actioins that are confirmed during a scenario
	static public OneToOne<Action, Action> actionHasBeenExecutedAsAnotherAction = new OneToOne<>("Has Been Executed As", "Has Replaced", "Planned Action", "Confirmed Action");
	static public AssociationClass<ItemReplacement, MissionItem, MissionItem> missionItemReplacesMissionItem =
			new AssociationClass<ItemReplacement, MissionItem, MissionItem>("Replaces", "Is Replaced By", ZeroOrOne, ZeroOrOne, "Mission Item", "Mission Item", "ItemReplacement");
	
	static public OneToMany<String, String> isFirstNameForLastName = new OneToMany<>("Is First Name For", "Is Last Name For", "First Name", "Last Name");
	
	static public String report()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(scenarioIsRetainedForAMission);
		str.append(scenarioHappenedDuringAMission);
		str.append("TO DO: scenarios that are considered for a mission\n");
		str.append(missionIsCarriedOutByACrew);
		str.append(scenarioIsComposedOfPlannedActions);
		str.append("TO DO: the confirmed actions of a scenario\n");
		str.append(actionHasBeenExecutedAsAnotherAction);
		str.append(missionItemReplacesMissionItem);
		
		return str.toString();
	}
}
