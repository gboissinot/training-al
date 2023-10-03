package fr.gboissinot.al.tps.oop.tp23;

import fr.gboissinot.al.tps.oop.tp23.kernel.Event;

final class PasswordChangedEvent implements Event {

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
