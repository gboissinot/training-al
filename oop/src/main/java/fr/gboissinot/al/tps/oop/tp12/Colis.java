package fr.gboissinot.al.tps.oop.tp12;

import java.time.LocalDateTime;

//Entity
final class Colis {

    private final ColisNumber number;
    private final LocalDateTime createdDate;
    private ColisStatus status;

    private Colis(ColisNumber number, LocalDateTime createdDate, Status status) {
        this.number = number;
        this.createdDate = createdDate;
        this.status = new ColisStatus();
        this.status.add(status);
    }

    public static Colis create(ColisNumber number) {
        return new Colis(number, LocalDateTime.now(), Status.IN_PREPARATION);
    }

    public void deliver() {
        this.status.add(Status.DELIVERED);
    }

    public void cancel() {
        if (this.status.value() != Status.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a package into preparation");
        }
        this.status.add(Status.CANCELED);
    }

    public ColisStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Colis{" +
                "number=" + number +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }
}
