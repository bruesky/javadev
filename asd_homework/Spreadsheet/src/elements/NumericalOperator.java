package elements;

import java.util.List;

public abstract class NumericalOperator extends Group
{
	protected List<Contents> getAllContentIOperateOn()
	{
		return Associations.groupIsMadeOfManyContents.leftToRights(this);		
	}
	
	protected String sign()
	{
		return null;
	}
	
	@Override
	public Boolean isOperator() {return true;}
	
	@Override
	public Boolean isEmptyOperator() 
	{
		return getContents().isEmpty();
	}
	
	@Override
	public Boolean isOperand()
	{
		return !isEmptyOperator();
	}
	
	
	public enum ID									// A quick way to compare operators while parsing expressions.
	{
		add, subtract, multiply, divide
	}
	ID myID = null;
	
	ID id() {return myID;}
	
	public Boolean isHigher(NumericalOperator no)	// Tells if this operator has a higher precedence 
	{
		return (myID == ID.multiply || myID == ID.divide) && (no.myID == ID.add || no.myID == ID.subtract);
	}
	
	public Boolean isSameAs(NumericalOperator no) 	// Tells whether these two operators are identical
	{
		return myID == no.myID;
	}

	@Override
	public String formula() 		// The mathematical description of what this operator is operating on
	{
		StringBuffer ret = new StringBuffer();

		Boolean firstLoop = true;

		if (getContents().isEmpty())
			ret.append(sign());
		else
		{
			ret.append("(");
			for (Contents contents : getAllContentIOperateOn())
			{
				if (firstLoop)
					firstLoop = false;
				else
					ret.append(sign());
	
				ret.append(contents.formula());
			}
			ret.append(")");
		}

		return ret.toString();
	}
}
