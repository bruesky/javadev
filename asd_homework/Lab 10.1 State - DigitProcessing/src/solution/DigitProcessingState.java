package solution;

abstract class DigitProcessingState
{
	private DigitProcessing context;
	
	public DigitProcessingState() {}
	
	protected DigitProcessing getContext() { return context; }
	void setContext(DigitProcessing context)
	{
		this.context = context;
	}	
	
	public void switchToState(DigitProcessingState newState)
	{
		// Invoke exit effect on current state
		onExit();
		
		// Set new state active
		context.switchToState(newState);
	}

	public void setActive(DigitProcessing context)
	{
		this.context = context;
		
		// Invoke entry effect on new state
		onEntry();
		
		// Invoke do activity
		doWhileInState();
	}

	public void onEntry() { System.out.println("Entering " + getClass().getSimpleName());}
	public void doWhileInState() {}
	public void onExit() {}
	public void enterPound() {}
	public void enterStar() {}
	public void enterDigit(int digit) {}
	public void hangup() {}	
	public void timeout() {}
}
