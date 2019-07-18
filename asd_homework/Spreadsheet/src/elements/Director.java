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
		new Parser(this, cell(row, col));
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
		setCell(1, 2, "(200*4)/2+5*(18-1)+0.15");						// Set cell's formula string, and build its contents accordingly	
		setCell(1, 4, "\"What we pay to the airlines\"");

		setCell(2, 1, "\"Taxi: \"");
		setCell(2, 2, "118");
		setCell(3, 1, "\"Rental Car:\"");
		setCell(3, 2, "295+.85");
		
		setCell(4, 1, "\"Hotel:\"");
		setCell(4, 2, "108*4");
		
		setCell(5, 1, "\"Meals:\"");
		setCell(5, 2, "50*3");
		setCell(5, 4, "\"All meals combined\"");

		setCell(7, 1, "\"Sub-total:\"");
		setCell(7, 2, "[1,2]+[2,2]+[3,2]+[4,2]+[5,2]");					// Sum total of all the cells referred to
		
		setCell(8, 1, "\"Discount:\"");									// Tax factor label
		setCell(8, 2, "0.15");											// Tax factor value
		
		setCell(9, 1, "\"Total:\"");

		setCell(9,2, "[7,2]*(1-[8,2])");
		setCell(10, 1, "\"Partners 007: \"");
		setCell(10, 2, "4");
		
		setCell(11, 1, "\"Months: \"");
		setCell(11, 2, "12");
		
		setCell(12, 1, "\"Installments:\"");
		setCell(12,2,"[9,2] / [10,2] / [11,2]");

	}
	
	public void buildSmallSample()
	{
		int i = 1;
		setCell(i++,1,"(1-5)");
		setCell(i++,1,"(10-(5))");
		
		setCell(i++,1,"((5))");		
		setCell(i++,1,"((2+3))");	

		setCell(i++,1,"(1-5*4)");
		setCell(i++,1,"(1-(5)*4)");
		setCell(i++,1,"1-(2+3)*4");
		setCell(i++,1,"(1-(2+3)*4)");
		setCell(i++,1,"1-(2*(1+2))*4");
		setCell(i++,1,"(1-(2*3)*4)");
		setCell(i++,1,"1-(5)*4");
		
		setCell(i++,1,"1-(2+3)*4");
		setCell(i++,1,"1+(2+3)*4");
		setCell(i++,1,"5-(1*4)");
		
		setCell(i++,1,"(2+1)*5");
		setCell(i++,1,"2+(3*5)-7");
		setCell(i++,1,"2*3+5");
		setCell(i++,1,"(2+1)*3+5");
		setCell(i++,1,"2*3+5");
		setCell(i++,1,"2*(3 + 1)+5");
		setCell(i++,1,"2*(3)+(5)*7");
		setCell(i++,1,"[3,1]*(5+5)");
		setCell(i++,1,"[6,1]+3*[5,1]");
		
		setCell(i++,1,"\"Text\"");
	}

}
