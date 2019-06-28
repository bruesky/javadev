package skeleton;

public class ActionItem extends Action
{

	public ActionItem(String nm, int num, String des)
	{
		super(nm, num, des);
	}
	
	@Override
	protected String getType()
	{
		return "Actionitem";
	}
	

}
