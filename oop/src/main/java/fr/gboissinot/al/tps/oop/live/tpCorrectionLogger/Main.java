package fr.gboissinot.al.tps.oop.live.tpCorrectionLogger;

public class Main {

    public static void main(String[] args) {
        MyService myService = new MyService(new ConsoleLogger(new MyTestFormatter()));
        myService.doSomething();
    }
}
