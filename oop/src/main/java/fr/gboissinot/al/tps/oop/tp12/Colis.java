package fr.gboissinot.al.tps.oop.tp12;

import java.time.LocalDateTime;

//Entity
final class Colis {

    private final ColisNumber number;
    private final LocalDateTime createdDate;
    private Status status;

    private Colis(ColisNumber number, LocalDateTime createdDate, ColisStatus colisStatus) {
        this.number = number;
        this.createdDate = createdDate;
        this.status = new Status();
        this.status.add(colisStatus);
    }

    public static Colis create(ColisNumber number) {
        return new Colis(number, LocalDateTime.now(), ColisStatus.IN_PREPARATION);
    }

    public void deliver() {
        this.status.add(ColisStatus.DELIVERED);
    }

    public void cancel() {
        if (this.status.value() != ColisStatus.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a package into preparation");
        }
        this.status.add(ColisStatus.CANCELED);
    }

    public Status getStatus() {
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
