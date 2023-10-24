package fr.gboissinot.al.tps.oop.tp4;

public class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    void doSomething() {
        logger.log("Do something");
    }
}
