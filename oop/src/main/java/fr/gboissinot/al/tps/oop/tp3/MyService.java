package fr.gboissinot.al.tps.oop.tp3;

final class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    public void doSomething() {
        logger.log("Processing in myMethod");
        //do something
    }
}
