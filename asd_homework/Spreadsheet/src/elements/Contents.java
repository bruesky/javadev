package elements;

public abstract class Contents extends Element
{
	public Contents(Cell cell)
	{
		if (cell != null)
			setCellOwner(cell);
	}
	
	public Contents()
	{
		
	}
	
	public Boolean isOperator() {return false;}
	public Boolean isEmptyOperator() {return false;}
	public Boolean isOperand() {return false;}
	public Boolean isNumericalValue() {return false;}
	public Boolean isText() {return false;}
	public Boolean isReference() {return false;}
	
	public void setCellOwner(Cell cl)
	{
		if (cl != null)
		{
			Associations.groupIsMadeOfManyContents.unlinkRight(this);		// Can belong to only one Cell or Group
			Associations.cellIsMadeOfContents.link(cl, this);				// Belongs to that Cell now
		}
	}

	public String getCoordinates()											// If belonging to a Cell, return its coordinates
	{
		String coordinates = new String();

		Cell cell = Associations.cellIsMadeOfContents.rightToLeft(this);
		if (cell != null)
			coordinates += cell.getCoordinates();

		return coordinates;
		
	}
}
