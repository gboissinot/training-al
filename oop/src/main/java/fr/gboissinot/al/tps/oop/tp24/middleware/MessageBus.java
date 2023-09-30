package fr.gboissinot.al.tps.oop.tp24.middleware;

public interface MessageBus {
    void send(String topic, Message message);
}
