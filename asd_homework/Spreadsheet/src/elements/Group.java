package elements;

import java.util.List;

public abstract class Group extends Contents
{
	public  Group append(Contents contents)
	{
		if (contents != null)
		{
			Associations.cellIsMadeOfContents.unlinkRight(contents);			// Make sure contents doesn't belong to any Cell
			Associations.groupIsMadeOfManyContents.link(this, contents);		// Link contents to this Group
		}
		return this;
	}
	
	public List<Contents> getContents()
	{
		return Associations.groupIsMadeOfManyContents.leftToRights(this);
	}

	@Override
	public String value() 
	{
		StringBuilder ret = new StringBuilder();
		ret.append(data());
		return ret.toString();
	}

}
