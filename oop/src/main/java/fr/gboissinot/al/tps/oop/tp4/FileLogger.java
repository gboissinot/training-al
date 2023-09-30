package fr.gboissinot.al.tps.oop.tp4;

import java.io.FileWriter;
import java.io.IOException;

final class FileLogger implements Logger {

    private final Formatter formatter;

    public FileLogger(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void log(String message) {
        var formattedMessage = formatter.format(message);
        try {
            try (FileWriter fileWriter = new FileWriter("logfile.log", true)) {
                fileWriter.append(formattedMessage);
                fileWriter.append("\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
