package fr.gboissinot.al.tps.oop.tp3;

final class MySecondLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[SECOND LOG] - " + message);
    }
}
