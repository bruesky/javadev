package formulas;
import elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Parser
{
	private Director director = null;							// The Director using this Parser
	private String formula = null;								// The string specifying the formula
	private List<Contents> elements = new ArrayList<Contents>();// The list of elements created from decoding the formula
	private Contents formulaObject = null;						// The one element holding the executable formula objects
	private int index = 0;										// Index to parse the formula String

	private StatePool pool = null;								// The pool that builds the State objects
	private State current = null;								// The current State of this Parser
	
	public Parser(Director dir, String form)
	{
		director = dir;
		formula = form;
		pool = new StatePool(this);
		current = pool.getInitialState();
	}
	
	public Parser(Director dir, Cell cell)
	{
		this(dir, cell.getFormulaString());
		buildElements();
		cell.setContent(formulaObject);
	}
	
	public Parser(String form, Director dir)					// This is the constructor we use for expressions within parenthesis
	{
		this(dir, form);
		buildElements();
	}
	
	public Contents getFormulaObject()
	{
		return formulaObject;
	}
	
	Director getDirector()
	{
		return director;
	}
	
	/*
	 * Build the formula object from the list of elements 
	 * Follow the rules of precedence and link all the elements in the list
	 * Put the result in the formulaObject
	 */
	
	public Element buildElements()
	{
		// System.out.println("buildElements() for: " + formula);	
		
		// Perform the parsing here:
		for (index = 0; index < formula.length(); index++)
		{
			char c = formula.charAt(index);
			if (Character.isDigit(c))
				current.numeric(c);
			else if (c == '.')
				current.dot();
			else if (c == ' ')
				current.blank();
			else if (c == ',')
				current.comma();	
			else if (c == '"')
				current.quote();
			else if (c == '[')
			{
				// System.out.println("Parser just found a left bracket");
				current.leftBracket();
			}
			else if (c == ']')
				current.rightBracket();
			else if (c == '(')
			{
				index++;														// Skip the '('
				Contents innerContents = buildParenthesisElements();			// Build objects between parenthesis
				if (innerContents != null)										// If we've built Contents objects
					append(innerContents);										// Append them to our elements
			}
			else if (c == ')')
				current.rightParenthesis();
			else if (c == '+')
				current.add();
			else if (c == '-')
				current.subtract();
			else if (c == '*')
				current.multiply();
			else if (c == '/')
				current.divide();
			else
				current.otherCharacters(c);
			
		}
		
		current.endString();
		
		// showElements();
		
		assembleElements();
		
		return formulaObject;
	}
	
	public Contents buildParenthesisElements()
	{
		Contents innerFormulaObject = null;							// The resulting object of our parsing
		StringBuilder parenthesisContents = new StringBuilder();	// The string of characters in-between the '(' and ')'
		Boolean doneParsing = false;								// We're done when we've encountered the matching ')'
		int leftParenthesisCount = 1;								// If we're here that's because there was one left parenthesis
		int rightParenthesisCount = 0;
		
		while (index < formula.length() && !doneParsing)			// Get to next 
		{
			char d = formula.charAt(index);
			if (d == '(')
				leftParenthesisCount++;
			else if (d == ')')
			{
				rightParenthesisCount++;
				if (rightParenthesisCount == leftParenthesisCount)
					doneParsing = true;	
			}
			
			if (!doneParsing)
				index++;			
			parenthesisContents.append(d);
		}
		
		if (doneParsing)
		{
			Parser innerParser = new Parser(parenthesisContents.toString(), director);	// Get another parser to extract the Contents objects
			innerFormulaObject = innerParser.getFormulaObject();	// This is the root of what this parser has built, probably an operator
		}
		
		return innerFormulaObject;
	}
	
	public Element assembleElements()
	{
		// Sprint 8: decoding and executing formulas like: "34 * 2 + 1 * 5 + [1,4] / 3", as well as "Some text"
		// We'll end up with either one text string, one numerical value, or the root of a tree of operators and operands
		
		Contents operand = null;									// The operand we find in the list of elements
		NumericalOperator currentOperator = null;					// The operator we're currently adding onto
		NumericalOperator emptyOperator = null;						// An empty operator found in the list of elements
		Contents root = null;										// The root of the overall tree of elements
		Contents newItem = null;									// The item from the list we're inspecting
		boolean done = false;
	 	ListIterator<Contents> items = elements.listIterator();		// The items that came our of our parsing

	 	while (!done && items.hasNext())
	 	{
	 		newItem = items.next();
	 		
	 		if (newItem.isText())
	 		{
	 			root = newItem;
	 			done = true;
	 		}
	 		else if (newItem.isEmptyOperator())
	 		{
	 			emptyOperator = (NumericalOperator) newItem;
	 			if (operand != null)
	 			{
	 				if (emptyOperator != operand)
	 				{
	 					currentOperator = emptyOperator;
	 					currentOperator.append(operand);
	 					operand = currentOperator;
	 					root = operand;
	 				}
	 				else if (emptyOperator == currentOperator)		// Do nothing, Another operand is probably coming
	 					;
	 			}
	 			else
	 				System.out.println("Empty Numerical Operator but no operand: " + emptyOperator.formula());											
	 				// Ignore empty operator: invalid entry		
	 		}
	 		else 
	 			if (newItem.isOperand())
	 			{
		 			if (currentOperator != null)
		 			{
		 				currentOperator.append(newItem);
		 				operand = currentOperator;
		 			}
		 			else
		 			{
		 				operand = newItem;
		 				root = operand;
		 			}
	 			}
	 			else
	 				System.out.println("No Text nor empty operator nor operand: " + newItem.formula());													// Ignore that item: probably a mistake
	 	}
		formulaObject = root;
		//System.out.println("FormulaObject: "+formulaObject.formula());
		
		return formulaObject;
	}

	
	public void switchToState(StatePool.States name)
	{
		current = pool.getState(name);
		current.setActive();
	}
	
	public void append(Contents contents)
	{
		elements.add(contents);
	}
	
	public void showElements()
	{
		ListIterator<Contents> items = elements.listIterator();	
		System.out.println("Showing " + elements.size() + " Elements");
		while (items.hasNext())
			System.out.println("    <" + items.next().formula() + ">");
	}
	
	// Events injected by other states:
	public void numeric(char a) { current.numeric(a); }
	public void dot() { current.dot(); }	
}
