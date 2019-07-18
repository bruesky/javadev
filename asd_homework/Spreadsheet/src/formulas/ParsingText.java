package formulas;

import elements.Text;

public class ParsingText extends State
{
	
	public ParsingText(Parser ps)
	{
		super(ps);
	}
	
	public void comma()				
	{
		contentString.append(",");	// Accepted like any other, non-command character
	}

	public void blank()
	{
		contentString.append(" ");	// Accepted like any other, non-command character		
	}

	public void dot()
	{
		contentString.append(".");	// Accepted like any other, non-command character		
	}

	@Override
	public void numeric(char a)
	{
		contentString.append(a);	// Accepted like any other, non-command character
	}
	
	@Override	
	public void add()
	{
		contentString.append("+");	// Accepted like any other, non-command character
		
	}
	
	@Override	
	public void subtract()
	{
		contentString.append("-");	// Accepted like any other, non-command character
	}
	
	@Override	
	public void multiply()
	{
		contentString.append("*");	// Accepted like any other, non-command character				
	}
	
	@Override	
	public void divide()
	{
		contentString.append("/");	// Accepted like any other, non-command character		
	}
	
	@Override	
	public void leftBracket()
	{
		contentString.append("[");	// Accepted like any other, non-command character	
	}
	
	@Override	
	public void rightBracket()
	{
		contentString.append("]");	// Accepted like any other, non-command character		
	}
	
	@Override	
	public void leftParenthesis()
	{
		contentString.append("(");	// Accepted like any other, non-command character		
	}
	
	@Override	
	public void rightParenthesis()
	{
		contentString.append(")");	// Accepted like any other, non-command character		
	}

	@Override	
	public void otherCharacters(char c)
	{
		contentString.append(c);
	}
	
	@Override
	public void quote()
	{
		switchTo(StatePool.States.waitingForToken);		
	}
	
	@Override 
	public void endString()
	{
		switchTo(StatePool.States.end);
	}

	@Override
	public void onExit()
	{
		parser.append(new Text(contentString.toString()));
	}

}
