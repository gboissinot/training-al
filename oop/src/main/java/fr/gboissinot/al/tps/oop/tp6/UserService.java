package fr.gboissinot.al.tps.oop.tp6;

final class UserService {

    private final UserRegistry userRegistry;

    public UserService(UserRegistry userRegistry) {
        this.userRegistry = userRegistry;
    }

    public User get(User user) {
        return userRegistry.getById(user.getId());
    }

    public void register(User user) {
        userRegistry.save(user);
    }
}
