package formulas;
import elements.NumericalValue;

public class ParsingNumber extends State
{		
	public ParsingNumber(Parser ps)
	{
		super(ps);
	}
	
	@Override
	public void numeric(char a)
	{
		contentString.append(a);
	}
	
	@Override
	public void dot()
	{
		contentString.append(".");
	}

	@Override 
	public void endString()
	{
		switchTo(StatePool.States.end);
	}
	
	@Override 
	public void blank()
	{
		switchTo(StatePool.States.waitingForToken);
	}
	
	@Override
	public void leftBracket()
	{
		switchTo(StatePool.States.parsingCell);		
	}
	
	public void add()
	{
		toBeDone = Transition.add;
		switchTo(StatePool.States.waitingForToken);
	}
	
	public void subtract()
	{
		toBeDone = Transition.subtract;
		switchTo(StatePool.States.waitingForToken);
	}
	
	public void multiply()
	{
		toBeDone = Transition.multiply;
		switchTo(StatePool.States.waitingForToken);
	}
	
	public void divide()
	{
		toBeDone = Transition.divide;
		switchTo(StatePool.States.waitingForToken);
	}
			
	@Override
	public void onExit()
	{
		if (contentString != null)
		{
			String flt = contentString.toString();
			
			if (!flt.isEmpty())
			{
				Float fl = new Float(flt);
				float number = fl.floatValue();	
				parser.append(new NumericalValue(number));		
			}
		}
	}
	

}
