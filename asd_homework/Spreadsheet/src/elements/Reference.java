package elements;

public class Reference extends Contents
{
	private Cell getCellReferredTo()
	{
		return Associations.referenceRefersToCell.leftToRight(this);
	
	}
	
	public Reference(Cell referredTo)	// This is for a cell to refer to another one
	{
		if (referredTo != null)
			refersTo(referredTo);
	}
	
	public Boolean isReference() {return true;}

	@Override
	public Boolean isOperand() { return true; }

	public void refersTo(Cell cell)			// Sets the Cell this Reference refers to
	{
		if (cell != null)
			Associations.referenceRefersToCell.link(this, cell);
	}
		
	@Override
	public String value() 
	{
		StringBuilder ret = new StringBuilder();

		Cell cell = getCellReferredTo();
		
		if (cell != null)
			ret.append(cell.value());
			
		return ret.toString();
	}

	@Override
	public String formula() 
	{
		StringBuilder ret = new StringBuilder();

		Cell cellReferredTo = getCellReferredTo();

		if (cellReferredTo != null)
			ret.append(cellReferredTo.getCoordinates());


		return ret.toString();
	}

	@Override
	public float data() 
	{
		float ret = 0;

		Cell cellReferredTo = getCellReferredTo();

		if (cellReferredTo != null)
			ret = cellReferredTo.data();

		return ret;
	}

}
