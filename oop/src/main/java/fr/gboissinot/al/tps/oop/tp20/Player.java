package fr.gboissinot.al.tps.oop.tp20;

import java.util.ArrayList;
import java.util.List;

final class Player {

    private final List<Event> recordedEvents;

    public Player(Position initialPosition) {
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new PlayerTookInitialPosition(initialPosition));
    }

    public void moveLeft(int steps) {
        this.recordedEvents.add(new PlayerMoved(steps, 0));
    }

    public List<Event> recordedEvents() {
        return recordedEvents;
    }

}
