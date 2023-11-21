package fr.gboissinot.al.tps.oop.tp12;

class Status {

    private History history;

    public Status() {
        this.history = History.create();
    }

    public void add(ColisStatus status) {
        this.history = this.history.add(status);
    }

    public ColisStatus value() {
        return history.getLatest();
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
