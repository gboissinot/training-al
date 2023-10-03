package fr.gboissinot.al.tps.oop.tp11;

import java.util.Objects;

//VO ID
final class ColisNumber {

    private final String value;

    public ColisNumber(String value) {
        this.value = value;
    }

    public static ColisNumber of(long value) {
        return new ColisNumber("#COLIS" + value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColisNumber that = (ColisNumber) o;
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
