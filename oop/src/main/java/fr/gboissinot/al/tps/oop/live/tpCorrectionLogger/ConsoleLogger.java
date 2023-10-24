package fr.gboissinot.al.tps.oop.live.tpCorrectionLogger;

public class ConsoleLogger implements Logger{

    private final Formatter formatter;

    public ConsoleLogger(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void log(String message) {
        System.out.println(formatter.format(message));
    }
}
