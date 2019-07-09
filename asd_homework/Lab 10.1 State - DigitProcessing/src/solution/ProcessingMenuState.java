package solution;

class ProcessingMenuState extends DigitProcessingState
{
	@Override
	public void enterStar()
	{
		System.out.println("  *");
		switchToState(new PlayingGreetingState());
	}	
	
	@Override
	public void enterDigit(int digit)
	{
		switch (digit)
		{
			case 1:
				System.out.println("  1");
				switchToState(new IdentifyingAccountState());
				break;
			case 2:
				System.out.println("  2 / Playing list of business services");
				switchToState(new ProcessingMenuState());
				break;
			case 3:
				System.out.println("  3 / Playing company profile");
				switchToState(new ProcessingMenuState());
				break;
			case 4:
				System.out.println("  4 / Telling address");
				switchToState(new ProcessingMenuState());
				break;
		}
	}
	
	@Override
	public void timeout()
	{
		System.out.println("  Timeout");
		switchToState(new PlayingGreetingState());
	}
}
