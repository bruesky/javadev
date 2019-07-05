package solution;

public class Customer
{
    public static final int PRESALE_CUSTOMER_ID = 0;
    
    private int customerId;
    private String name;
    private CustomerServiceCenter center;
    
    public Customer(String name, CustomerServiceCenter center)
    {
        this(PRESALE_CUSTOMER_ID, name, center);
    }
    
    public Customer(int customerId, String name, CustomerServiceCenter center)
    {
        this.customerId = customerId;
        this.name = name;
        this.center = center;
    }
    
    public void makeServiceRequest(int subject,
                                   String question)
    {
        System.out.println("Request: " + subject + " - " + question);
        
        ServiceRequest request = new ServiceRequest(this, subject, question);
        center.requestService(request);
        
        System.out.println("Result: " + request.getResponse() + "\n");
    }
    
    public int getCustomerId() { return customerId; }
    public String getName()    { return name; }
    
    public void setCustomerId(int customerId) { this.customerId = customerId; }
}
