package fr.gboissinot.al.kernel;

public interface Event {
    default String name() {
        return getClass().getSimpleName();
    }
}
