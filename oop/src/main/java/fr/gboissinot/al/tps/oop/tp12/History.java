package fr.gboissinot.al.tps.oop.tp12;

import java.util.ArrayList;
import java.util.List;

//VO
final class History {

    private final List<Status> history;

    private History(List<Status> history) {
        this.history = history;
    }

    public static History create() {
        return new History(new ArrayList<>());
    }

    public static History create(Status initialStatus) {
        final ArrayList<Status> list = new ArrayList<>();
        list.add(initialStatus);
        return new History(list);
    }

    public History add(Status status) {
        List<Status> statusList = new ArrayList<>(history);
        statusList.add(status);
        return new History(statusList);
    }

    public Status getLatest() {
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
