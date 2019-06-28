package skeleton;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

public class ItemReplacement
{
	private static List<ItemReplacement> instances = new Vector<>();
	public static List<ItemReplacement> getInstances() {return instances;}

	private LocalDate time = LocalDate.now();
	private String comments;

	public ItemReplacement(String cmmt)
	{
		instances.add(this);
		comments = cmmt;
	}

	public ItemReplacement(String cmmt, ActionItem originalItem, ActionItem newItem)
	{
		this(cmmt);
		Associations.missionItemReplacesMissionItem.link(this, originalItem, newItem);
	}

	public String getComments() { return comments; }
	public String toString() { return report(); }
	public String report() 
	{ 
		return "Item Replacement: <" + time + ", " + comments + ">";
	}
	
}
