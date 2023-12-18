package fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model;


//VO
public final class Email {
    private final String email;

    private Email(String email) {
        this.email = email;
    }

    public static Email of(String email) {
        return new Email(email);
    }

    public String value() {
        return email;
    }
}
