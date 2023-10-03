package fr.gboissinot.al.tps.oop.tpDemo2;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private final String logFilePath;

    public FileLogger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    @Override
    public void log(String message) {
//        ensureLogFileExists();
        try {
            try (FileWriter fileWriter = new FileWriter(logFilePath, true)) {
                fileWriter.append(message);
                fileWriter.append("\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void ensureLogFileExists() {
//        //TODO Make code here
//    }
}
