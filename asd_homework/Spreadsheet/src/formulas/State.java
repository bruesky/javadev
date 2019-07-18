package formulas;
import elements.*;

public class State
{
	StringBuilder contentString = null;
	// Actions to perform on transition
	enum Transition
	{
		none, add, subtract, multiply, divide
	}
	
	Transition toBeDone = Transition.none;
	
	
	protected Parser parser;
		
	public State(Parser ps)
	{
		parser = ps;
	}
	
	public void setActive()
	{
		onEntry();
	}
	
	public void onEntry()
	{
		contentString = new StringBuilder();		// Get a fresh copy
	}
	
	public void onExit()
	{
		
	}
	
	public void onTransition()
	{
		//System.out.println("State.onTransition():" + toBeDone);
		if (toBeDone == Transition.add)
			parser.append(new Add());
		else if (toBeDone == Transition.subtract)
			parser.append(new Subtract());
		else if (toBeDone == Transition.multiply)
			parser.append(new Multiply());
		else if (toBeDone == Transition.divide)
			parser.append(new Divide());
		
		clearTransition();
	}
	
	void clearTransition() { toBeDone = Transition.none; }
	
	public void switchTo(StatePool.States state)
	{
		//System.out.println("State.switchTo()" + state + ", toBeDone is: " + toBeDone);
		onExit();
		onTransition();
		parser.switchToState(state);
	}
	
	// All the events:
	public void numeric(char a){}
	public void dot(){}
	public void blank(){}
	public void comma(){}
	public void quote(){}
	public void endString() {}
	
	public void add() {}	
	public void subtract(){}
	public void multiply() {}
	public void divide() {}
	
	public void leftBracket() {}
	public void rightBracket(){}
	
	public void leftParenthesis(){}
	public void rightParenthesis(){}
	
	public void otherCharacters(char c){}
}
