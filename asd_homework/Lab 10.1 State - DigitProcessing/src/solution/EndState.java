package solution;

class EndState extends DigitProcessingState
{	
	// In the EndState none of the behavior is available
	public void onEntry() { super.onEntry(); }
	public void doWhileInState() {}
	public void onExit() {}
	public void enterPound() {}
	public void enterStar() {}
	public void enterDigit(int digit) {}
	public void hangup() {}	
	public void timeout() {}
}
