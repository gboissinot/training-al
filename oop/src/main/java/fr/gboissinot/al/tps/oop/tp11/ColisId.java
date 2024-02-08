package fr.gboissinot.al.tps.oop.tp11;

import java.util.Objects;

//VO ID
final class ColisId {

    private final String value;

    public ColisId(String value) {
        this.value = value;
    }

    public static ColisId of(long value) {
        return new ColisId("#COLIS" + value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColisId that = (ColisId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ColisNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
