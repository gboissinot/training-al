package fr.gboissinot.al.tps.oop.tp6;

public class Main {

    //Illustration of IOC Pattern (Assemblage)
    public static void main(String[] args) {
        var userRepository = new InMemoryUserRepository();
        var userService = new UserService(userRepository); //Uses the DI pattern
        var user = User.of("BOISSINOT", "GREGORY");
        userService.register(user);
        System.out.println(userService.get(user));
    }
}
