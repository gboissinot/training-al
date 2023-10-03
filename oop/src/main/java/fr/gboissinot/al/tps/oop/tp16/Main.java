package fr.gboissinot.al.tps.oop.tp16;

import fr.gboissinot.al.tps.oop.tp16.domain.services.UserService;
import fr.gboissinot.al.tps.oop.tp16.exposition.ChangeUserRequest;
import fr.gboissinot.al.tps.oop.tp16.exposition.CreateUserRequest;
import fr.gboissinot.al.tps.oop.tp16.exposition.UserController;
import fr.gboissinot.al.tps.oop.tp16.infrastructure.MySQLUsers;

public class Main {

    public static void main(String[] args) {
        var userRequest = new CreateUserRequest("BOISSINOT", "GREGORY");
        var userController = new UserController(new UserService(new MySQLUsers()));
        userController.createUser(userRequest);

        final ChangeUserRequest changeUserRequest = new ChangeUserRequest("BOISSINOT", "NEW NAME");
        userController.changeLastName(changeUserRequest);


    }
}
