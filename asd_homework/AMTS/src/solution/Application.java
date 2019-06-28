package solution;

public class Application
{	
	public Application()
	{
		System.out.println(Associations.report());
		Domain domain = new Domain();
		domain.buildDynamicObjects();
		domain.showInstances();
	}

	public static void main(String[] args)
	{
		new Application();
	}
	
}
