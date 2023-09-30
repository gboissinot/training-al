package fr.gboissinot.al.tps.oop.tp15.infrastructure;

import fr.gboissinot.al.tps.oop.tp15.domain.UserDao;
import fr.gboissinot.al.tps.oop.tp15.domain.model.User;

public final class MySQLUserDao implements UserDao {
    @Override
    public void create(User user) {
        System.out.println("MYSQL Creation with " + user);
    }
}
