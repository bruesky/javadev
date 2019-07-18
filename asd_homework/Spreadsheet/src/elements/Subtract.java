package elements;

public class Subtract extends NumericalOperator
{
	protected String sign() 
	{ 
		return " - "; 
	}
	
	public Subtract() { myID = ID.subtract; }

	@Override
	public float data() 
	{
		float result = 0;

		Boolean firstItem = true;

		for (Contents contents : getAllContentIOperateOn())
			if (contents != null)
				if (firstItem)
				{
					result = contents.data();
					firstItem = false;
				}
				else if (contents.data() != 0)			// Don't divide by zero, it's rude
					result -= contents.data();
		
		return result;
	}

}
