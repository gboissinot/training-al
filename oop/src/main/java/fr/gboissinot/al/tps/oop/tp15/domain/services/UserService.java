package fr.gboissinot.al.tps.oop.tp15.domain.services;

import fr.gboissinot.al.tps.oop.tp15.domain.UserPersistence;
import fr.gboissinot.al.tps.oop.tp15.domain.model.User;

public final class UserService {

    private final UserPersistence userPersistence;

    public UserService(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void create(String lastname, String firstname) {
        var user = new User(lastname, firstname);
        userPersistence.save(user);
    }
}
