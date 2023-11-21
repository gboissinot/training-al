package fr.gboissinot.al.tps.oop.tp14;

import java.util.UUID;

final class UserService {

    private final UserPersistence userPersistence;

    public UserService(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    void create(CreateUserRequest createUserRequest) {
        User user = new User(UUID.randomUUID().toString(), createUserRequest.lastname, createUserRequest.firstname);
        userPersistence.save(user);
    }
}
