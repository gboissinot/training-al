package fr.gboissinot.al.tps.oop.tp14;

public class Main {

    public static void main(String[] args) {
        var userRequest = new CreateUserRequest("BOISSINOT", "GREGORY");
        var userService = new UserService(new InMemoryUserPersistence());
        userService.create(userRequest);
    }
}
