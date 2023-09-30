package fr.gboissinot.al.tps.oop.tp15;

import fr.gboissinot.al.tps.oop.tp15.exposition.UserController;
import fr.gboissinot.al.tps.oop.tp15.exposition.UserRequest;
import fr.gboissinot.al.tps.oop.tp15.infrastructure.MySQLUserDao;
import fr.gboissinot.al.tps.oop.tp15.services.UserService;

public class Main {

    public static void main(String[] args) {
        var userRequest = new UserRequest("BOISSINOT", "GREGORY");
        var userController = new UserController(new UserService(new MySQLUserDao()));
        userController.createUser(userRequest);
    }
}
