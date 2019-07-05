package skeleton;


public class Application
{
    public static void main(String[] args)
    {
        Application app = new Application();
        app.run();
    }
    
    public void run()
    {
        CustomerServiceCenter center = new CustomerServiceCenter();
        
        // Pre-sale customer
        Customer customer = new Customer("Francis Mosse", center);       
        customer.makeServiceRequest(
                ServiceRequest.SUBJECT_HIFI, 
                "Which speakers are best for my room size and shape?");
                
        // Post-sale customer
        customer = new Customer(1, "Ed Strassberger", center);      
        customer.makeServiceRequest(
                ServiceRequest.SUBJECT_VIDEO, 
                "The camcorder screen doesn't work sometimes.");
        
        // Request that nobody can handle
        customer = new Customer("Phil Harmonica", center);        
        customer.makeServiceRequest(
                ServiceRequest.SUBJECT_FOTO, 
                "What is the maximum shutter speed on the Nikon X500 model?");
    }
}
