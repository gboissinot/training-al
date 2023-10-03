package fr.gboissinot.al.tps.oop.tp6;

public class Main {

    public static void main(String[] args) {
        var userRegistry = new InMemoryUserRegistry();
        var userService = new UserService(userRegistry);
        var user = User.of("BOISSINOT", "GREGORY");
        userService.register(user);
        System.out.println(userService.get(user));
    }
}
