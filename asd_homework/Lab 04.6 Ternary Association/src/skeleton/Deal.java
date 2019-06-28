package skeleton;

class Deal
{
	private static int currentNumber = 1;
	private static int getNextNumber() { return currentNumber++; }

	private int number;
	
	// TODO: Implement ternary association ends
	
	
	public Deal()
	{
		number = getNextNumber();
		
		// TODO: Instantiate ternary association 
		
	}

	public int getNumber() { return number; }
	
	public void show()
	{
		System.out.println("Deal #" + number + ": ");
		
		// TODO: Print out name of each related object
		
		System.out.println();
	}
}
