package fr.gboissinot.al.tps.oop.tp4;

public class Main {

    public static void main(String[] args) {
        var message = "Hello gboissinot";
        //var logger = new FileLogger(new DefaultFormatter());
        //Logger logger = message1 -> System.out.println("[MAIN LOGGER] " + message1);
        MyService myService = new MyService(new NullLogger());
        myService.doSomething();
    }
}
