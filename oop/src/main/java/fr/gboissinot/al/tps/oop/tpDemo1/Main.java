package fr.gboissinot.al.tps.oop.tpDemo1;

public class Main {

    public static void main(String[] args) {
        MyService myService = new MyService(new NullLogger());
        myService.myMethod();
    }
}
