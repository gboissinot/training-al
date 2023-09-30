package fr.gboissinot.al.tps.oop.tp3;

final class DefaultLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[DEFAULT] " + message);
    }
}
