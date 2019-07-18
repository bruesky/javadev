package formulas;

public class StatePool
{
	private Parser parser = null;
	
	public enum States
	{
		waitingForToken,
		parsingNumber,
		parsingText,
		end
	}
	
	State waitingForToken;
	State parsingNumber;
	State parsingText;
	State parsingCell;
	State end;
	
	public StatePool(Parser p)
	{
		parser = p;
		
		//Create all the states
		waitingForToken = new WaitingForToken(parser);
		parsingNumber = new ParsingNumber(parser);
		parsingText = new ParsingText(parser);
		end = new End(parser);
	}
	
	public State getInitialState()
	{
		return getState(States.waitingForToken);
	}
	
	public State getState(States name)
	{
		State requested = null;
		
		if (name == States.waitingForToken)
			requested = waitingForToken;
		else if (name == States.parsingNumber)
			requested = parsingNumber;
		else if (name == States.parsingText)
			requested = parsingText;
		else 
			requested = end;
			
		return requested;
	}

}
