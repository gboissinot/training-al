package fr.gboissinot.al.tps.oop.tpDemo1;

public final class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    public void myMethod() {
        logger.log("MY METHOD MESSAGE");
    }
}
