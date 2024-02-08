package fr.gboissinot.al.tps.oop.tp11;

import java.time.LocalDateTime;
import java.util.Objects;

//Entity
final class Colis {

    private final ColisId id;
    private final LocalDateTime createdDate;
    private ColisStatus status;

    private Colis(ColisId id, LocalDateTime createdDate, ColisStatus status) {
        this.id = id;
        this.createdDate = createdDate;
        this.status = status;
    }

    public static Colis create(ColisId number) {
        return new Colis(number, LocalDateTime.now(), ColisStatus.IN_PREPARATION);
    }

    public void deliver() {
        this.status = ColisStatus.DELIVERED;
    }

    public void cancel() {
        if (this.status != ColisStatus.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a package.");
        }
        this.status = ColisStatus.CANCELED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colis colis = (Colis) o;
        return Objects.equals(id, colis.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Colis{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }
}
