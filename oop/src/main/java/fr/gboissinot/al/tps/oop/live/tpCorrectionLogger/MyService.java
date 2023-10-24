package fr.gboissinot.al.tps.oop.live.tpCorrectionLogger;

public class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    void doSomething(){
        logger.log("do something");
    }
}
