package ChainofResponsibilityPattern;

public class RuntimeLogger extends Logger {
    public RuntimeLogger() {
        super(1);
    }

    @Override
    public void logInfo() {
        System.out.println("Runtime Logger Info");
    }
}
