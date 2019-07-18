package elements;

import Framework.*;

public class Associations
{
	static public OneToOne<Cell, Contents> cellIsMadeOfContents = 
					new OneToOne<Cell, Contents>("Contains", "Belongs To", "Owner", "Contents");
	static public ManyToOne<Reference, Cell> referenceRefersToCell = 
					new ManyToOne<Reference, Cell>("Refers To", "Is Referred To By", "Cell", "Reference");
	static public OneToMany<Group, Contents> groupIsMadeOfManyContents =
					new OneToMany<Group, Contents>("Is Made Of", "Belongs To", "Group", "Content");
	
	static public String report()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(cellIsMadeOfContents);
		str.append(referenceRefersToCell);
		str.append(groupIsMadeOfManyContents);
		
		return str.toString();
	}

}
