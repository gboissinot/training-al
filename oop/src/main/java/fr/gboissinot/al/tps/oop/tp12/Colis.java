package fr.gboissinot.al.tps.oop.tp12;

import java.time.LocalDateTime;

//Entity
final class Colis {

    private final ColisId id;
    private final LocalDateTime createdDate;
    private ColisStatus status;

    private Colis(ColisId id, LocalDateTime createdDate, Status status) {
        this.id = id;
        this.createdDate = createdDate;
        this.status = new ColisStatus();
        this.status.add(status);
    }

    public static Colis create(ColisId number) {
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
                "id=" + id +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }
}
