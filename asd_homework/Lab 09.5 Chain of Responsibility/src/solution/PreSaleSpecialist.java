package solution;

public class PreSaleSpecialist extends TechSupportSpecialist
{
    public PreSaleSpecialist(int id,
                             String name)
    {  
        this(id, name, null);
    }
    
    public PreSaleSpecialist(int id,
                             String name,
                             TechSupportSpecialist previous)
    {
        super(id, name, previous);
    }
    
    public boolean isResponsibleFor(Customer customer)
    {
        int customerId = customer.getCustomerId();       
        return customerId == Customer.PRESALE_CUSTOMER_ID;
    }
    
    protected void resolveRequest(ServiceRequest request)
    {
        System.out.println("Request handled by Pre Sale Specialist:");
        System.out.println("  Specialist Id:   " + getId());
        System.out.println("  Specialist Name: " + getName());
        request.setResponse("Don't worry be happy.");
    }
}
