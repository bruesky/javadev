package skeleton;

public class SingleScenario extends Scenario
{
	public SingleScenario(String nm, int num, String des, boolean act)
	{
		super(nm, num, des, act);
	}
	
	@Override
	protected String getType() { return "Scenario"; }
}
