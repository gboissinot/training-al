package fr.gboissinot.al.tps.oop.tp12;

import java.util.ArrayList;
import java.util.List;

//VO
final class History {

    private final List<ColisStatus> history;

    private History(List<ColisStatus> history) {
        this.history = history;
    }

    public static History create() {
        return new History(new ArrayList<>());
    }

    public static History create(ColisStatus initialStatus) {
        final ArrayList<ColisStatus> list = new ArrayList<>();
        list.add(initialStatus);
        return new History(list);
    }

    public History add(ColisStatus status) {
        List<ColisStatus> statusList = new ArrayList<>(history);
        statusList.add(status);
        return new History(statusList);
    }

    public ColisStatus getLatest() {
        if (history.size() == 0) {
            throw new UnsupportedOperationException();
        }
        return history.get(history.size() - 1);
    }

    @Override
    public String toString() {
        return "History{" +
                "history=" + history +
                '}';
    }
}
