package fr.gboissinot.al.tps.oop.live.tpCorrectionLogger;

import java.util.Locale;

public class DefaultFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "[PREFIX] - " + message.toUpperCase(Locale.ROOT);
    }
}
