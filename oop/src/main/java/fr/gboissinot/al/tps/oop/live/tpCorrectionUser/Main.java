package fr.gboissinot.al.tps.oop.live.tpCorrectionUser;

public class Main {

    public static void main(String[] args) {
        var registry = new StubUserRegistry();
        var userService = new UserService(registry);

        var userToRegister = User.of("Grgeory", "BOISSINOT");
        userService.addUser(userToRegister);

        var registeredUser = registry.getById(userToRegister.getId());
        System.out.println(registeredUser);
    }
}
