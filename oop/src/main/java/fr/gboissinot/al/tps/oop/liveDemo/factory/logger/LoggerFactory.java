package fr.gboissinot.al.tps.oop.liveDemo.factory.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class LoggerFactory {

    private LoggerFactory() {
        throw new AssertionError();
    }

    public static Logger createFileLogger(String logFilePathValue) {
        try {
            Path logFilePath = createFileIfNotExist(logFilePathValue);
            return new FileLogger(logFilePath);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static Path createFileIfNotExist(String logFilePathValue) throws IOException {
        Path logFilePath = Path.of(logFilePathValue);

        final Path logFilePathParent = logFilePath.getParent();
        if (!Files.isDirectory(logFilePathParent)) {
            Files.createDirectory(logFilePathParent);
        }
        if (Files.notExists(logFilePath)) {
            Files.createFile(logFilePath);
        }
        return logFilePath;
    }
}
