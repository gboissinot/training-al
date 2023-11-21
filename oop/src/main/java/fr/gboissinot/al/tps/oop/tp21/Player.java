package fr.gboissinot.al.tps.oop.tp21;

import java.util.ArrayList;
import java.util.List;

final class Player {

    private final List<Event> recordedEvents;

    public Player(Position intialPosition) {
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new PlayerTookInitialPosition(intialPosition));
    }

    public void moveLeft(int steps) {
        this.recordedEvents.add(new PlayerMoved(steps, 0));
    }

    public Position currentPosition() {
        Position readPosition = new Position(0, 0);
        for (Event recordedEvent : recordedEvents) {
            if (recordedEvent instanceof PlayerTookInitialPosition) {
                readPosition = ((PlayerTookInitialPosition) recordedEvent).getPosition();
            }
            if (recordedEvent instanceof PlayerMoved) {
                readPosition = readPosition.toTheLeft(((PlayerMoved) recordedEvent).getX());
            }
        }

        return readPosition;
    }
}
