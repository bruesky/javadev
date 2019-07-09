package solution;

class IdentifyingAccountState extends DigitProcessingState
{
	@Override
	public void onEntry()
	{
		super.onEntry();
		System.out.println("  Prompting for account number");
	}
	
	@Override
	public void enterStar()
	{
		System.out.println("  *");
		switchToState(new ProcessingMenuState());
	}
	
	@Override
	public void enterPound()
	{
		System.out.println("  #");
		if (getContext().isValidAccount())
		{
			System.out.println("  Valid account number: Supplying account info");
			System.out.println(getContext().getAccount());
			getContext().reset();
			switchToState(this);
		}
		else
		{
			System.out.println("  Invalid account number: Incrementing trials");
			getContext().incrementTrials();
			if (getContext().hasMoreTrials())
				switchToState(this);	
			else
			{
				System.out.println("  Too many trials / Reporting problem");
				switchToState(new EndState());	
			}
		}
	}
	
	@Override
	public void enterDigit(int digit)
	{
		System.out.println("  digit / Appending digit " + digit + " to account number");
		getContext().addDigit(digit);
	}
	
	@Override
	public void timeout()
	{
		System.out.println("  Timeout");
		switchToState(new IdentifyingAccountState());
	}
}
