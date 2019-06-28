package skeleton;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mission
{
	private static List<Mission> instances = new ArrayList<>();	// A container of all the instances from this class
	public static List<Mission> getInstances() { return instances; }		// Simple access to the container of instances
	
	private String codeName;
	private String name;
	private String description;
	private String goal;
	private LocalDate time;													// Mission object's creation time		


	public Mission(String cn, String nm, String descr, String gl)
	{
		instances.add(this);
		codeName = cn; name = nm; description = descr; goal = gl;
		time = LocalDate.now();
	}
	
	public Mission(Mission mission)
	{
		this(mission.codeName, mission.name, mission.description, mission.goal);
	}

	public void setName(String nm) { if (nm != null) name = nm; }
	public String getName() { return name; }
	
	public Scenario getDesignatedPlan() { return Associations.scenarioIsRetainedForAMission.rightToLeft(this); }
	// TO DO: implement this useful method: public List<Scenario> getResearchPlans() {}
	public Scenario getActualScenario() { return Associations.scenarioHappenedDuringAMission.rightToLeft(this); }

	public Crew getMissionCrew() { return Associations.missionIsCarriedOutByACrew.leftToRight(this); }
	public void isCarriedOutByCrew(Crew crew) { Associations.missionIsCarriedOutByACrew.link(this, crew); }

	public String getReport(String indentation)
	{
		StringBuilder report = new StringBuilder(indentation);
		
		report.append("Mission: [" + codeName + "]" + ", \"" + name + "\", " + description + ", " + time.toString() + "\n");
		
		indentation += "\t";
		// TO DO: report on all the research plans

		Scenario designatedPlanScenario = getDesignatedPlan();								// Using the Associations Framework
		if (designatedPlanScenario != null)
			report.append(indentation + "Designated Plan :" + designatedPlanScenario.getReport(""));

		Crew crew = getMissionCrew();
		if (crew != null)
			report.append(indentation + "This Mission is carried out by: " + crew + "\n");
		
		return report.toString();
	}
	
	public String toString() { return getReport(""); }
};
