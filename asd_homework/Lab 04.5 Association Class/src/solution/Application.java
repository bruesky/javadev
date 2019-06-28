package solution;

public class Application
{
	private Domain domain;
	private UI ui;

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
