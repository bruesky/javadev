package elements;

import formulas.Parser;

public class Director
{
	private Spreadsheet spreadsheet;	

	public Director(Spreadsheet sps)
	{
	spreadsheet = sps;
	}

	public Spreadsheet getSpreadsheet() { return spreadsheet; }

	public void writeInCellText(int r, int c, String text)
	{
		if (text != null)
			spreadsheet.cell(r, c).setContent(new Text(text));	
	}
	
	public void writeInCellNumber(int r, int c, float numb)
	{
		spreadsheet.cell(r, c).setContent(new NumericalValue(numb));
	}
	
	public void setFormula(int r, int c, String formula)
	{
		spreadsheet.cell(r, c).setFormula(formula);
		
	}
	
	public Cell cell(int row, int col) 							// Get a reference to cell at (row,col)
	{ 
		return spreadsheet.cell(row, col); 
	}	
	
	public void setCell(int row, int col, String formula)
	{
		setFormula(row, col, formula);
		new Parser(cell(row, col));
	}

	public String contents()
	{
		return spreadsheet.show();
	}

	public String describe()
	{
		return spreadsheet.describe();
	}

	public String examine()
	{
		return spreadsheet.examine();
	}
	
	public void buildSample()											// Build sample data for development purpose
	{
		setCell(1, 1, "\"Airfare:\"");
		
		setCell(1, 2, "200*4/2+90-5+0.15");								// Set cell's formula string, and build its contents accordingly		
		setCell(1, 3, "");
		setCell(1, 4, "\"What we pay to the airlines\"");

		setCell(2, 1, "\"Taxi: \"");
		setCell(2, 2, "118");
		setCell(3, 1, "\"Rental Car:\"");
		setCell(3, 2, "295+.85");
		setCell(4, 1, "\"Hotel:\"");
		setCell(4, 2, "431");
		setCell(5, 1, "\"Meals:\"");
		setCell(5, 2, "115+2+3+4*5*6/3-7/8");
		setCell(5, 3, "");
		setCell(5, 4, "\"All meals combined\"");

		setCell(7, 1, "\"Sub-total:\"");
		
		Add add = new Add();
		for (int i = 1; i <= 5; i++)									// For cells on column 2 and rows from 1 to 5
			add.append(new Reference(spreadsheet.cell(i, 2)));			// ...add their references to "total"
		spreadsheet.cell(7, 2).setContent(add);							// Make that sum total the contents of (7,2)
		cell(7,2).setContent(add);										// Put that in [7,2]
		
		setCell(8, 1, "\"Discount:\"");									// Tax factor label
		setCell(8, 2, "0.15");											// Tax factor value
		setCell(9, 1, "\"Total:\"");

		Multiply multiply = new Multiply();
		multiply.append(new Reference(spreadsheet.cell(7, 2)));			// Multiply sub-total
		Subtract onePlusTaxFactor = new Subtract();						// ... by the subtraction of...
		multiply.append(onePlusTaxFactor);
		onePlusTaxFactor.append(new NumericalValue(1.0F));				// ... 1 minus
		onePlusTaxFactor.append(new Reference(spreadsheet.cell(8, 2)));	// ... the tax factor

		spreadsheet.cell(9, 2).setContent(multiply);					// Put result in that cell
		
		setCell(10, 1, "\"Partners 007: \"");
		setCell(10, 2, "4");
		setCell(11, 1, "\"Months: \"");
		setCell(11, 2, "12");
		setCell(12, 1, "\"Installments:\"");

		Divide division = new Divide();
		division.append(new Reference(spreadsheet.cell(9, 2)));
		division.append(new Reference(spreadsheet.cell(10, 2)));
		division.append(new Reference(spreadsheet.cell(11, 2)));
		spreadsheet.cell(12, 2).setContent(division);

	}

}
