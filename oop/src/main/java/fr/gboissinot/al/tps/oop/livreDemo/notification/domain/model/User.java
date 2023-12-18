package fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model;

import java.util.Objects;

//Entity
public final class User {

    private final String id;
    private final String firstname;
    private String lastname;
    private final Email email;

    public User(String id, String lastname, String firstname, Email email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    public void changeLastName(String newLastName) {
        this.lastname = newLastName;
    }
}
