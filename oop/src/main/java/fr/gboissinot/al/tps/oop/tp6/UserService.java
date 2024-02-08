package fr.gboissinot.al.tps.oop.tp6;

// Brings all application use cases
final class UserService {

    //Use of DIP pattern
    private final UserPersistence userPersistence;

    public UserService(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public User get(User user) {
        return userPersistence.getById(user.getId());
    }

    //Registration Use case
    public void create(User user) {
        userPersistence.save(user);
    }
}
