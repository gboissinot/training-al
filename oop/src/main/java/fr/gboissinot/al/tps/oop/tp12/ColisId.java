package fr.gboissinot.al.tps.oop.tp12;

//VO ID
final class ColisId {

    private final String value;

    private ColisId(String value) {
        this.value = value;
    }

    public static ColisId of(long value) {
        return new ColisId("#COLIS" + value);
    }

    @Override
    public String toString() {
        return "ColisNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
