package fr.gboissinot.al.tps.oop.tpDemo1;

public class DummyLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("MY TEST MESSAGE");
    }
}
