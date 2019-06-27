package AssociationClass;
public class Application
{
	Domain domain;
	UI ui;

	public Application()
	{
		domain = new Domain();
		ui = new UI();
	}

	public static void main(String args[])
	{
		new Application();
	}

}
