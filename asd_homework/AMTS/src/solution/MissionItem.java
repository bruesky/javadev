package solution;

import Framework.Triplet;

public abstract class MissionItem 
{
	
	private int number;
	private String name; 
	private String description;
		
	protected abstract String getType();
	
	protected String noLineBreak(String str)									// Take out the end-of-line from a String
	{
		return str;
	}
	
	public MissionItem(String nm , int num, String des)
	{
		name = nm; number = num; description = des;
	}
	
	public Triplet<ItemReplacement, MissionItem, MissionItem> replaces() 
	{ 
		return Associations.missionItemReplacesMissionItem.firstFromLeft(this);
	}
	
	public Triplet<ItemReplacement, MissionItem, MissionItem> isReplacedBy() 
	{ 
		return Associations.missionItemReplacesMissionItem.firstFromRight(this);
	}
		
	public String getReport(String indentation)											// Algorithm template
	{
		StringBuilder report = new StringBuilder(indentation);
		
		report.append(getType() + " #: " + number + ", " + name + ", " + description + ", " + getExtendedReport(indentation));

		Triplet<ItemReplacement, MissionItem, MissionItem> replacement = replaces();	// Does this MissionItem REPLACE another one?
		
		if (replacement != null && replacement.hasNoNulls())							// If there is a replacement then its members will not be NULL
			report.append(indentation + "\t" + "--> Replaces: [" + replacement.right.number + "] " + "\"" + replacement.right.name + "\", because: " + replacement.linkObject.getComments() + "\n");
		
		replacement = isReplacedBy();													// Is this MissionItem REPLACED BY another one?
		
		if (replacement != null && replacement.hasNoNulls())							// If there is a replacement then its members will not be NULL
			report.append(indentation + "\t" + "--> Replaced by: [" + replacement.left.number + "] " + "\"" + replacement.left.name + "\", because: " + replacement.linkObject.getComments() + "\n");
		
		
		return report.toString();
	}
	
	public abstract String getExtendedReport(String indent);					// This step is deferred to subclass(es)
	
	public String toString() { return getReport(""); }
	
}
