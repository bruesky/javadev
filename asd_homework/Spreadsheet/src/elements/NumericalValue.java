package elements;

public class NumericalValue extends Contents
{
	private float number;

	public NumericalValue(float nb)
	{
		number = nb;
	}

	public Boolean isNumericalValue() {return true;}
	
	@Override
	public Boolean isOperand()
	{
		return true;
	}


	public void setNumber(float nb) 
	{ 
		number = nb; 
	}
	
	public String value()
	{
		StringBuilder ret = new StringBuilder();

		ret.append(number);

		return ret.toString();
		
	}
	
	public String formula()
	{
		return value();
	}
	
	public float data() 
	{ 
		return number; 
	}	

}
