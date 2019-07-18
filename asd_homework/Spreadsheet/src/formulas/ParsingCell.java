package formulas;

import elements.Cell;
import elements.Reference;

public class ParsingCell extends State
{
	StringBuilder row;
	StringBuilder column;
	Boolean rowIsParsed;
	
	private void initialize()
	{
		row = new StringBuilder();
		column = new StringBuilder();
		rowIsParsed = false;
	}
	
	public ParsingCell(Parser ps)
	{
		super(ps);
	}
	
	@Override
	public void onEntry()
	{
		super.onEntry();
		initialize();
	}

	@Override
	public void numeric(char a)			// Append character values to the row or column strings
	{
		// System.out.println(a);
		if (!rowIsParsed)				// If we are still parsing the row value
			row.append(a);				// ...append to it
		else							// If we're parsing the column value
			column.append(a);			// ...append to it
	}
	
	@Override
	public void comma()					// We expect a comma as soon as the row value has been parsed
	{
		rowIsParsed = true;
	}

	@Override
	public void rightBracket()
	{
		// System.out.println("rightBracket()");
		switchTo(StatePool.States.waitingForToken);		
	}
	
	@Override
	public void onExit()
	{
		int rowValue = (new Integer(row.toString())).intValue();
		int columnValue = (new Integer(column.toString())).intValue();
		Cell cell = parser.getDirector().cell(rowValue, columnValue);
		Reference reference = new Reference(cell);
		parser.append(reference);
	}
}
