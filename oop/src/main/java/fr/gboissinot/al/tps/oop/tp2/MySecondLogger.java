package fr.gboissinot.al.tps.oop.tp2;

final class MySecondLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[LOG2] - " + message);
    }
}
