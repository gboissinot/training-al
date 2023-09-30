package fr.gboissinot.al.kernel;

public interface EventHandler<E extends Event> {
    void handle(E event);
}
