package fr.gboissinot.al.tps.oop.livreDemo.notification.exposition;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.services.UserService;

//Controller
public final class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(CreateUserRequest createUserRequest) {
        //DTO Validation
        if (createUserRequest.lastname == null) {
            throw new IllegalArgumentException("A user lastname is required.");
        }

        if (createUserRequest.firstname == null) {
            throw new IllegalArgumentException("A user firstname is required.");
        }

        userService.create(createUserRequest.lastname, createUserRequest.firstname, createUserRequest.email);
    }

    public void changeLastName(ChangeUserRequest changeUserRequest) {
        if (changeUserRequest.id == null) {
            throw new IllegalArgumentException("A user identifier is required.");
        }

        if (changeUserRequest.newLastName == null) {
            throw new IllegalArgumentException("The new lastname is required.");
        }

        userService.changeUser(changeUserRequest.id, changeUserRequest.newLastName);
    }
}
