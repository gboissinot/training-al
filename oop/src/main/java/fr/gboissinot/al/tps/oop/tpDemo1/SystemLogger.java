package fr.gboissinot.al.tps.oop.tpDemo1;

public final class SystemLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
