package fr.gboissinot.al.tps.oop.tp9.infrastructure;

import fr.gboissinot.al.tps.oop.tp9.domain.UserDAO;

//MySQL implementation for UserDAO
public final class MySQLUserDAO implements UserDAO {

    @Override
    public void create(String username, String password) {
        //TODO Technical code to implement insertion into MySQL
        System.out.println("MYSQL creation...");
    }
}
