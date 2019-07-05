package solution;

public class ServiceRequest
{
    public static final int STATUS_OPEN     = 1;
    public static final int STATUS_ASSIGNED = 2;
    public static final int STATUS_CLOSED   = 3;
    
    public static final int SUBJECT_HIFI     = 1;
    public static final int SUBJECT_VIDEO    = 2;
    public static final int SUBJECT_FOTO     = 3;
    public static final int SUBJECT_COMPUTER = 4;
    
    private Customer customer;
    private int subject;
    private String question;
    private int status;
    private String response;

    public ServiceRequest(Customer customer, int subject, String question)
    {
        this.customer = customer;
        this.subject = subject;
        this.question = question;
        this.status = STATUS_OPEN;
    }

    public Customer getCustomer() { return customer; }
    public int getSubject()    { return subject; }
    public String getQuestion()   { return question; }
    public int getStatus()        { return status; }
    public String getResponse()     { return response; }
    
    public void setStatus(int status)    { this.status = status; }  
    public void setResponse(String result) { this.response = result; }
}
