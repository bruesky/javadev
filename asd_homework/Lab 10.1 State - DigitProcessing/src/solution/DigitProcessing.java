package solution;

/**
 * This is the context class which assumes different states at different times.
 */
public class DigitProcessing
{
	private static final int MAX_TRIALS = 3;

	private String accountNumber = null;
	private int trials = 0;
	private DigitProcessingState state = null;
	
	public DigitProcessing()
	{
		reset();
		// Set initial state
		state = new PlayingGreetingState();
		state.setActive(this);
	}
	
	void reset()
	{
		accountNumber = null;
		trials = 0;
	}
	boolean hasMoreTrials() { return trials < MAX_TRIALS; }
	void incrementTrials() { trials++; }
	void addDigit(int digit) { accountNumber += digit; }
	boolean isValidAccount() 
	{
		Account account = Account.find(accountNumber);
		return account != null;
	}
	Account getAccount() { return Account.find(accountNumber); }
	
	public void switchToState(DigitProcessingState newState)
	{
		state = newState;
		newState.setActive(this);
	}

	public void enterPound() { state.enterPound(); }
	public void enterStar() { state.enterStar(); }
	public void enterDigit(int digit) { state.enterDigit(digit); }
	public void hangup() { state.hangup(); }
	public void timeout() { state.timeout(); }
}
