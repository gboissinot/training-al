package fr.gboissinot.al.tps.oop.tp15;

import fr.gboissinot.al.tps.oop.tp15.exposition.UserController;
import fr.gboissinot.al.tps.oop.tp15.exposition.CreateUserRequest;
import fr.gboissinot.al.tps.oop.tp15.infrastructure.MySQLUserDao;
import fr.gboissinot.al.tps.oop.tp15.domain.services.UserService;

public class Main {

    public static void main(String[] args) {
        var userRequest = new CreateUserRequest("BOISSINOT", "GREGORY");
        var userController = new UserController(new UserService(new MySQLUserDao()));
        userController.createUser(userRequest);
    }
}
