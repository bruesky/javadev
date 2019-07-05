package skeleton;

import java.util.ArrayList;
import java.util.List;

public abstract class TechSupportSpecialist
{
    private int id;
    private String name;
    private boolean available = true;
    private List subjects = new ArrayList();
    private TechSupportSpecialist next = null;
    
    public TechSupportSpecialist(int id,
                                 String name)
    {  
        this(id, name, null);
    }
    
    public TechSupportSpecialist(int id,
                                 String name,
                                 TechSupportSpecialist previous)
    {
        this.id = id;
        this.name = name;

        // TODO: tell the previous specialist that this is the next one in the chain.
    }
    
    public int getId()           { return id; }
    public String getName()      { return name; }
    public boolean isAvailable() { return available; }
    public List getSubjects()    { return subjects; }
    public boolean isQualifiedToHandle(int subject)
    {
        return subjects.contains(new Integer(subject)); 
    }
    
    public void setAvailable(boolean available) { this.available = available; }
    public void setNext(TechSupportSpecialist next) { this.next = next; }
    public void addSubject(int subject)
    {
        subjects.add(new Integer(subject));
    }
    
    /**
     * Checks whether this specialist is able to handle the request. If not,
     * it passes the request to the next specialist in the chain.
     */
    public void handleRequest(ServiceRequest request)
    {
        // TODO
    }
    
    /**
     * Checks if this specialist is trained to service requests for this 
     * customer type.
     */
    public abstract boolean isResponsibleFor(Customer customer);
    
    /**
     * Produces an answer to the customers service request.
     */
    protected abstract void resolveRequest(ServiceRequest request);
}
