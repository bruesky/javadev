package solution;

class PlayingGreetingState extends DigitProcessingState
{
	@Override
	public void onEntry()
	{
		super.onEntry();
		System.out.println("  entry / Playing greeting");
	}
	
	@Override
	public void doWhileInState()
	{
		System.out.println("  do / Telling top menu");
	}
	
	@Override
	public void enterDigit(int digit)
	{
		switch (digit)
		{
			case 1:
				System.out.println("  1");
				switchToState(new PlayingGreetingState());
				break;
		}
	}
	
	@Override
	public void enterStar()
	{
		System.out.println("  *");
		switchToState(new ProcessingMenuState());
	}
	
	@Override
	public void timeout()
	{
		System.out.println("  Timeout / Playing good bye message & hanging up");
		switchToState(new EndState());
	}
}
