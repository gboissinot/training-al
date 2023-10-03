package fr.gboissinot.al.tps.oop.tpDemo2;

public class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    void myMethod() {
        logger.log("My MESSAGE");
    }
}
