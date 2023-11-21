package fr.gboissinot.al.tps.oop.tp14;

final class UserService {

    private final UserPersistence userPersistence;

    public UserService(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    void create(CreateUserRequest createUserRequest) {
        User user = new User(createUserRequest.lastname, createUserRequest.firstname);
        userPersistence.create(user);
    }
}
