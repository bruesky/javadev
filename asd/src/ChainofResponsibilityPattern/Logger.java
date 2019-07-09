package ChainofResponsibilityPattern;

public abstract class Logger {
    private Logger next;
    private int level;

    public Logger(int level) {
        this.level = level;
    }

    public void setNext(Logger next){
        this.next = next;
    }

    public int getLevel() {
        return level;
    }

    public Logger getNext() {
        return next;
    }

    public void logMessage(int level){
        if(this.level <= level){
            logInfo();
        }
        if(next !=null){
            next.logMessage(level);
        }
    }

    public abstract void logInfo();
}
