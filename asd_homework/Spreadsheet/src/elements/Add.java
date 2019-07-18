package elements;

public class Add extends NumericalOperator
{
	protected String sign() 
	{ 
		return " + "; 
	}
	
	public Add() { myID = ID.add; }

	@Override
	public float data() 
	{
		float sumOfAll = 0;

		for (Contents contents : getAllContentIOperateOn())
			if (contents != null)
				sumOfAll += contents.data();

		return sumOfAll;
	}

}
