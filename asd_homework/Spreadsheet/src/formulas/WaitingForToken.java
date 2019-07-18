package formulas;

import elements.*;

public class WaitingForToken extends State
{
	
	public WaitingForToken(Parser ps)
	{
		super(ps);
	}
	
	@Override
	public void onEntry()
	{
		super.onEntry();
		//System.out.println("WaitingForToken.onEntry()");
	}
	
	@Override
	public void numeric(char a)
	{
		switchTo(StatePool.States.parsingNumber);
		parser.numeric(a);
	}
	
	@Override
	public void dot()					// For numerics starting with a do, like ".85" which means "0.85"
	{
		switchTo(StatePool.States.parsingNumber);
		parser.numeric('0');
		parser.dot();
	}
	
	@Override
	public void quote()
	{
		switchTo(StatePool.States.parsingText);
	}
	
	@Override
	public void add()
	{
		parser.append(new Add());
	}
	
	@Override
	public void subtract()
	{
		parser.append(new Subtract());
	}
	
	@Override
	public void divide()
	{
		parser.append(new Divide());
	}
	
	@Override
	public void multiply()
	{
		parser.append(new Multiply());
	}
	
}
