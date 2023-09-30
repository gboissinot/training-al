package fr.gboissinot.al.tps.oop.tp24.middleware;

import java.util.UUID;

public final class MessageEncoder {
    public Message encode(String logMessage) {
        return new SimpleMessage(UUID.randomUUID().toString(), logMessage);
    }
}
