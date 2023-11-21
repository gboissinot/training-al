package fr.gboissinot.al.tps.oop.livreDemo.notification;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.services.UserService;
import fr.gboissinot.al.tps.oop.livreDemo.notification.exposition.CreateUserRequest;
import fr.gboissinot.al.tps.oop.livreDemo.notification.exposition.UserController;
import fr.gboissinot.al.tps.oop.livreDemo.notification.infrastructure.EmailLogGateway;
import fr.gboissinot.al.tps.oop.livreDemo.notification.infrastructure.EmailNotifications;
import fr.gboissinot.al.tps.oop.livreDemo.notification.infrastructure.MySQLUsers;

public class Main {
    public static void main(String[] args) {
        var users = new MySQLUsers();
        var notifications = new EmailNotifications(new EmailLogGateway());
        var userService = new UserService(users, notifications);
        var userController = new UserController(userService);
        var createUserRequest = new CreateUserRequest(
                "BOISSINOT",
                "GREGORY",
                "gregory.boissinot@gmail.com");
        userController.createUser(createUserRequest);
    }
}
