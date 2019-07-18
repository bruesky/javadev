package elements;

public class Multiply extends NumericalOperator
{
	protected String sign() { return " * "; }
	
	public Multiply() { myID = ID.multiply; }
	
	@Override
	public float data() 
	{
		float prodOfAll = 1;

		for (Contents contents : getAllContentIOperateOn())
			if (contents != null)
				prodOfAll *= contents.data();

		return prodOfAll;
	}

}
