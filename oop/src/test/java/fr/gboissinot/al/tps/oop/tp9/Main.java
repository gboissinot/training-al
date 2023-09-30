package fr.gboissinot.al.tps.oop.tp9;

import fr.gboissinot.al.tps.oop.tp9.domain.UserService;

public class Main {
    public static void main(String[] args) {
        final UserService userService = ServiceContainer.getUserService();
        userService.createUser("GREGORY", "admin123");
    }
}
