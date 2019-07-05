package solution;

public class CustomerServiceCenter
{
    private TechSupportSpecialist serviceChain;

    /**
     * Creates chain of support specialists.
     */
    public CustomerServiceCenter()
    {
        int id = 1;
        TechSupportSpecialist specialist;

        specialist = new PreSaleSpecialist(
                id++, 
                "Mary Miller");
        specialist.addSubject(ServiceRequest.SUBJECT_VIDEO);
        specialist.addSubject(ServiceRequest.SUBJECT_COMPUTER);
        serviceChain = specialist;
        
        specialist = new PostSaleSpecialist(
                id++, 
                "John Smith", 
                specialist);
        specialist.addSubject(ServiceRequest.SUBJECT_HIFI);
        specialist.addSubject(ServiceRequest.SUBJECT_FOTO);
        
        specialist = new PostSaleSpecialist(
                id++, 
                "Rachel Johnson", 
                specialist);
        specialist.addSubject(ServiceRequest.SUBJECT_VIDEO);
        
        specialist = new PreSaleSpecialist(
                id++, 
                "Frank Martin", 
                specialist);
        specialist.addSubject(ServiceRequest.SUBJECT_HIFI);
              
        specialist = new PostSaleSpecialist(
                id++, 
                "Frank Martin", 
                specialist);
        specialist.addSubject(ServiceRequest.SUBJECT_COMPUTER);
        specialist.addSubject(ServiceRequest.SUBJECT_FOTO);
    }
    
    /**
     * Hands the request to the chain of specialists.
     */
    public void requestService(ServiceRequest request)
    {
        serviceChain.handleRequest(request);
    }
}
