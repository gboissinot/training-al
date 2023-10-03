package fr.gboissinot.al.tps.oop.tpDemo2;

public final class LoggerFactory {

    private LoggerFactory() {
        throw new AssertionError();
    }

    public static Logger createFileLogger(String fileLogPath) {

        //Business logic
        return new FileLogger(fileLogPath);
    }
}
