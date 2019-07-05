package skeleton;

class CompTerms extends DomainObject
{
	private static ObjectManager manager = new ObjectManager();	
	public static ObjectManager getManager() { return manager;}	

	private double commissionPercent;
	private CompTerms previous;		// The CompTerms this object is replacing

	public CompTerms(double commissionPercent, SalesConsultant salesConsultant)
	{
		manager.addObject(this);

		this.commissionPercent = commissionPercent;
		salesConsultant.setCompTerms(this);
	}

	public double getCommissionPercent() { return commissionPercent; }
	public void setCommissionPercent(double commissionPercent) 
	{
		this.commissionPercent = commissionPercent;
	}

	public CompTerms getPrevious() { return previous; }
	public void setPrevious(CompTerms previous) { this.previous = previous; }

	public double getCommission(double amount) 
	{
		return amount * commissionPercent;
	}
}