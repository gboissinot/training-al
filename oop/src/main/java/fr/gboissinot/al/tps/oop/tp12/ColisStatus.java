package fr.gboissinot.al.tps.oop.tp12;

class ColisStatus {

    private History history;

    public ColisStatus() {
        this.history = History.create();
    }

    public void add(Status status) {
        this.history = this.history.add(status);
    }

    public Status value() {
        return history.getLatest();
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
