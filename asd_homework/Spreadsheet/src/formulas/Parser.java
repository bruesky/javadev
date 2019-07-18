package formulas;
import elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Parser
{
	private String formula = null;								// The string specifying the formula
	private List<Contents> elements = new ArrayList<Contents>();	// The list of elements created from decoding the formula
	private Contents formulaObject = null;						// The one element holding the executable formula objects
	

	private StatePool pool = null;								// The pool that builds the State objects
	private State current = null;								// The current State of this Parser
	
	public Parser(String form)
	{
		formula = form;
		pool = new StatePool(this);
		current = pool.getInitialState();
	}
	
	public Parser(Cell cell)
	{
		this(cell.getFormulaString());
		buildElements();
		cell.setContent(formulaObject);
	}
	
	/*
	 * Build the formula object from the list of elements 
	 * Follow the rules of precedence and link all the elements in the list
	 * Put the result in the formulaObject
	 */
	
	public Element buildElements()
	{
		// Perform the parsing here:
		for (int i = 0; i < formula.length(); i++)
		{
			char c = formula.charAt(i);
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
				current.leftBracket();
			else if (c == ']')
				current.rightBracket();
			else if (c == '(')
				current.leftParenthesis();
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
		
		assembleElements();
		
		return formulaObject;
	}
	
	public Element assembleElements()
	{
		// Sprint 6: Still reduced functionality, but doing more...
		// ...decoding and executing formulas like: "34 * 2 + 1 + 6 / 3", as well as "Some text"
		// We'll end up with either one text string, one numerical value, or the root of a tree of operators and operands
		
		if (elements.size() > 0)
			if (elements.get(0).isText())									// For now, if there is some text, then that's all there is
				formulaObject = elements.get(0);
			else															// Other than text will be numbers, operators, and references
			{
				ListIterator<Contents> items = elements.listIterator();		// Iterator on the elements
				Contents newItem = null;									// The item from the list we're inspecting--operand or operator
				Contents operand = null;									// The operand we find in the list of elements
				NumericalOperator currentOperator = null;					// The operator we're currently adding onto
				NumericalOperator newOperator = null;						// The new operator we're finding in the list
				Contents root = null;										// The root of the overall tree of elements
				
				while (items.hasNext())										// While list has more items
				{
					newItem = items.next();									// get the operand
					if (newItem.isNumericalValue())							// Is that new item a numerical value?
					{
						operand = newItem;									// This new item is our operand
						if (currentOperator != null)						// if we're already having an operator
							currentOperator.append(operand);				// ...append operand to it
						else 												// must be first iteration: we don't even have an operator yet
							{
								if (!items.hasNext())						// If it is the end of the list
									root = operand;							// That's it! there's just one number in that list
								else
								{
									newItem = items.next();					// Get next item
									if (newItem.isOperator())				// Should be an operator
									{
										currentOperator = (NumericalOperator) newItem;	// ...the current one
										newOperator = currentOperator;		// As this is the first and only operator, it also is the new one
										currentOperator.append(operand);	// Put the operand in the operator
									}
									// If that wasn't an operator, we'll silently skip that element--not supposed to be here
								}
							}
						if (currentOperator != null)
							root = currentOperator;							// If there is a current operator, it's the root
					}
					else if (newItem.isOperator())							// If this is an operator		
					{
						newOperator = (NumericalOperator) newItem;			// Make it the new one
						if (newOperator != currentOperator)					// If new operator is different from the current one
						{
							if (currentOperator != null)					// If there already is a current operator...
								newOperator.append(currentOperator);		// ...append it to the new one
							currentOperator = newOperator;					// New operator now becomes the current one
							root = currentOperator;							// and the current operator is the root
						}
					}
					
				} 
				if (root != null)											// If we've put a numerical value or an operator there...
					formulaObject = root;									// ...then it's our final formula object
			}	
		
		return formulaObject;
	}
	
	
	public void switchToState(StatePool.States name)
	{
		current = pool.getState(name);
		current.setActive();
	}
	
	public void append(Contents contents)
	{
		//System.out.println("Parser.append("+contents.formula()+")");
		elements.add(contents);
	}
	
	// Events injected by other states:
	public void numeric(char a) { current.numeric(a); }
	public void dot() { current.dot(); }

	
}
