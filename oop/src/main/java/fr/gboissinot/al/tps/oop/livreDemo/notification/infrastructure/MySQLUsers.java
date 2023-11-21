package fr.gboissinot.al.tps.oop.livreDemo.notification.infrastructure;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.Users;
import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model.User;

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
        //TODO Implement me
        throw new UnsupportedOperationException();
    }
}
