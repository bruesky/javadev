package solution;

public class Application
{
	public static void main(String[] args)
	{
		new Account("7898", 1500);
		new Account("8231", 5200);
		
		System.out.println("*** Call 1: ***");
		DigitProcessing call1 = new DigitProcessing();
		call1.enterDigit(1);
		call1.timeout();	
		
		System.out.println("\n*** Call 2: ***");
		DigitProcessing call2 = new DigitProcessing();
		call2.enterStar();
		call2.enterStar();
		call2.enterStar();
		call2.timeout();
		call2.enterStar();
		call2.enterDigit(4);
		call2.enterDigit(2);
		call2.enterDigit(3);
		call2.enterDigit(1);
				
		call2.enterStar();
		call2.enterDigit(1);
		call2.timeout();
		
		call2.enterDigit(7); 		
		call2.enterDigit(8); 		
		call2.enterDigit(9); 		
		call2.enterDigit(8); 	// Valid
		call2.enterPound();
		
		call2.enterDigit(6);		
		call2.enterDigit(6);		
		call2.enterDigit(6);		
		call2.enterDigit(6);	// Invalid
		call2.enterPound();
		
		call2.enterDigit(6);		
		call2.enterDigit(6);		
		call2.enterDigit(6);		
		call2.enterDigit(6);	// Invalid
		call2.enterPound();
		
		call2.enterDigit(6);		
		call2.enterDigit(6);		
		call2.enterDigit(6);		
		call2.enterDigit(6);	// Invalid. Max trials reached.
		call2.enterPound();
	}
}
