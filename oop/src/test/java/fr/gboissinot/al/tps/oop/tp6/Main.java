package fr.gboissinot.al.tps.oop.tp6;

public class Main {

    //Illustration of DI Pattern (Assemblage)
    public static void main(String[] args) {
        var userRepository = new InMemoryUserPersistence();
        var userService = new UserService(userRepository); //Uses the DI pattern
        var user = User.of("BOISSINOT", "GREGORY");
        userService.create(user);
        System.out.println(userService.get(user));
    }
}
