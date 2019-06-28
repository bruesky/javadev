package skeleton;

public class Domain
{
	public void buildDynamicObjects()
	{
		// Build Missions
		Mission[] missions=
		{
		new Mission("CM01", "Mojave survey", "Inspection of Mojave Desert's key locations", "Detect any abnormal statuses"),
		new Mission("CM02", "Mojave setup", "Setup of Mojave Desert's new locations", "Identify at least 12 key location candidates"),
		new Mission("CM03", "Death Valley exploration", "Discovery of Death valley's attributes", "Learn the main features of Death Valley"),
		new Mission("CM04", "Jaw Bone Town Census", "Estimate the town's current population", "Provide this community in transition a close watch of its assets"),
		};
		
		int i = 0;
		final int survey = i++, setup = i++, exploration = i++, census = i++, numbMissions = missions.length;
		
		// Build Mission Items (Scenarios and Actions)

		SingleScenario[] singleScenarios =
		{
			new SingleScenario("Traditional Survey", 9000, "Most common way to survey an area", true),
			new SingleScenario("Quick Survey", 9004, "Quick way to survey an area", true),
			new SingleScenario("Deep Survey", 9008, "Detailed way to survey an area", true),
			new SingleScenario("Special Survey", 9020, "Special way to survey an area", true),
			new SingleScenario("Unpredicted Survey", 7070, "The way a particular survey happened.", true),
		};
		
		i = 0;
		final int traditional = i++, quick = i++, deep = i++, special = i++, unpredicted = i++, numbScenarios = singleScenarios.length;

		// Assign Scenarios to Mission(s)
		Mission theMojaveSurvey = missions[survey];
		// TO DO: "quick", "deep", and "survey" scenarios are considered for the Mojave Survey

		singleScenarios[special].isRetainedFor(theMojaveSurvey);						// This Scenario is retained for the first Mission
		
		// TODO: theMojaveSurvey				// This Scenario is no longer considered for the first Mission

		// Build Actions
		ActionItem[] actionItems =
		{
		new ActionItem("Take off", 1010, "Take off to 10,000 feet"),
		new ActionItem("Reach Mojave Desert", 1020, "Reach south-west part of the desert"),
		new ActionItem("Inspect", 1030, "Survey the entire area for anomalies"),
		new ActionItem("Return", 1040, "Fly back to base and land"),
		};

		i = 0;
		int takeoff = i++, reach = i++, inspect = i++, flyback = i++, numbOfActionItems = actionItems.length;

		for (Action action : actionItems)												// Start all the actions
			action.start();
		
		Scenario retainedForMojave = theMojaveSurvey.getDesignatedPlan();
		
		for (Action action : actionItems)												// Populate Scenario with the Actions that are planned for it
			retainedForMojave.addPlannedAction(action);

		// Now, that scenario was executed... Here is what happened

		// First Action happened exactly as planned
		// TODO: takeoff is confirmed

		// Second Action was modified
		ActionItem actualReachingOfMojave = new ActionItem("Reach Mojave Desert Elsewhere!", 1025, "Reach the center-south part of the desert");
		actionItems[reach].hasBeenExecutedAs(actualReachingOfMojave);					// actualReachingOfMojave has been executed in lieu of the original "reach" Action Item
		// TODO //actualReachingOfMojave is a Confirmed Action of that Scenario

		// In this particular case, we desire to document further why the original Action was replaced with another one
		// ...the mechanism for that is to use the "Replaces" Association class, with its "Item Replacement" concept. 
		new ItemReplacement("Center-South has been declared more urgent", actualReachingOfMojave, actionItems[reach]);
		actualReachingOfMojave.setCompleted();

		// Next two Actions happened as planned
		// TO DO: the "inspect" and "flyback" actions are confirmed for the "retainedForMojave" scenario
		
		// Build Crews
		Crew[] crews =
		{
		new Crew("Alpha"),
		new Crew("Bravo"),
		new Crew("Charlie"),
		new Crew("Delta"),
		};
		i = 0;
		int alpha = i++, bravo = i++, charlie = i++, delta = i++, numbCrews = crews.length;

		// Assign Crew(s) to Mission(s)
		theMojaveSurvey.isCarriedOutByCrew(crews[alpha]);

		for (Action action : actionItems)				// Stop all the actions
		{
			action.stop();
			if (action != actionItems[reach]) 
				action.setCompleted();
		}
		
	}
	
	public void showInstances()
	{
		for (Mission mission : Mission.getInstances())
			System.out.println(mission);	
	}

}
