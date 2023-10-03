package fr.gboissinot.al.tps.oop.tpDemo3.domain;

import fr.gboissinot.al.tps.oop.tpDemo3.infrastructure.MySQLUserDao;

public class MyService {

    private final UserDao userDao;

    public MyService(MySQLUserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.insert(user);
    }
}
