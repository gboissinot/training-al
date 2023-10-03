package fr.gboissinot.al.tps.oop.tp15.exposition;

import fr.gboissinot.al.tps.oop.tp15.domain.services.UserService;

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
        userService.create(createUserRequest.lastname, createUserRequest.firstname);
    }
}
