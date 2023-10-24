package fr.gboissinot.al.tps.oop.live.tpCorrectionRegistry2;

public class UserService {

    private final UserRegistry userRegistry;

    public UserService(UserRegistry userRegistry) {
        this.userRegistry = userRegistry;
    }

    public String register(String firstname, String lastname){
        var user = User.of(firstname,lastname);
        userRegistry.save(user);
        return user.getId();
    }
}
