package fr.gboissinot.al.tps.oop.tpCorrectionUser;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;
    private final String firstname;
    private final String lastname;

    private User(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
    }

    public static User of(String firstname, String lastname) {
        return new User(counter.incrementAndGet(), firstname, lastname);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
