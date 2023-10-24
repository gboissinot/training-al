package fr.gboissinot.al.tps.oop.live.tpCorrectionRegistry2;

import java.util.Objects;
import java.util.UUID;

final class User {

    private final String id;
    private final String firstname;
    private final String lastname;

    private User(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
    }

    public String getId() {
        return id;
    }

    public static User of(String firstname, String lastname) {
        return new User(UUID.randomUUID().toString(), firstname, lastname);
    }

    public static User of(String id, String firstname, String lastname) {
        return new User(id, firstname, lastname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
