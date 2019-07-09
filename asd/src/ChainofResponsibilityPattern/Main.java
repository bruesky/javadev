package ChainofResponsibilityPattern;

public class Main {

    public static Logger getLogerChain(){

        RuntimeLogger runtimeLogger = new RuntimeLogger();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        ErrorLogger errorLogger  = new ErrorLogger();
        runtimeLogger.setNext(consoleLogger);
        consoleLogger.setNext(errorLogger);
        return runtimeLogger;
    }

    public static void main(String[]args){
        Logger loggerChain = getLogerChain();

        loggerChain.logMessage(1);
        loggerChain.logMessage(2);
        loggerChain.logMessage(3);
    }

}
