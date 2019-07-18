package elements;

public class Divide extends NumericalOperator
{
	protected String sign() { return " / "; }

	public Divide() { myID = ID.divide; }

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
					result /= contents.data();
		
		return result;
	}

}
