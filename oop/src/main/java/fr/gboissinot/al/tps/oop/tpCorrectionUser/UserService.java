package fr.gboissinot.al.tps.oop.tpCorrectionUser;

public class UserService {

    private final UserRegistry registry;

    public UserService(UserRegistry registry) {
        this.registry = registry;
    }

    public void addUser(User user) {
        registry.save(user);
    }
}
