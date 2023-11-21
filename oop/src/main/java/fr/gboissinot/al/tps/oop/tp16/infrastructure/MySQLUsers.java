package fr.gboissinot.al.tps.oop.tp16.infrastructure;

import fr.gboissinot.al.tps.oop.tp16.domain.Users;
import fr.gboissinot.al.tps.oop.tp16.domain.model.User;

import java.util.UUID;

public final class MySQLUsers implements Users {

    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void add(User user) {
        System.out.println("MYSQL Insert ou update");
    }

    @Override
    public void delete(User user) {
        System.out.println("MYSQL delete");
    }

    @Override
    public User getById(String id) {
        throw new UnsupportedOperationException();
    }
}
