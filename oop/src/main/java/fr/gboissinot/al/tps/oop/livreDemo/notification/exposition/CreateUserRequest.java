package fr.gboissinot.al.tps.oop.livreDemo.notification.exposition;

//DTO
public final class CreateUserRequest {

    public final String lastname;
    public final String firstname;
    public final String email;

    public CreateUserRequest(String lastname, String firstname, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }
}
