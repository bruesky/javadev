package ChainofResponsibilityPattern;

public class ErrorLogger extends Logger {

    public ErrorLogger() {
        super(3);
    }

    @Override
    public void logInfo() {
        System.out.println("Error Logger");
    }
}
