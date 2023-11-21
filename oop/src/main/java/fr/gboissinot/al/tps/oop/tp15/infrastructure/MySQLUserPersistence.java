package fr.gboissinot.al.tps.oop.tp15.infrastructure;

import fr.gboissinot.al.tps.oop.tp15.domain.UserPersistence;
import fr.gboissinot.al.tps.oop.tp15.domain.model.User;

public final class MySQLUserPersistence implements UserPersistence {
    @Override
    public User getById(String id) {
        //TODO Implement me
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(User user) {
        System.out.println("MYSQL Creation with " + user);
    }
}
