package fr.gboissinot.al.tps.oop.tp15.exposition;

//DTO Object
public final class CreateUserRequest {

    public final String lastname;
    public final String firstname;

    public CreateUserRequest(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
