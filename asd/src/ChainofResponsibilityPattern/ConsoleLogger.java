package ChainofResponsibilityPattern;

public class ConsoleLogger extends Logger {

    public ConsoleLogger() {
        super(2);
    }



    @Override
    public void logInfo() {
        System.out.println("Console Logger Info");
    }
}
