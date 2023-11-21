package fr.gboissinot.al.tps.oop.livreDemo.notification.infrastructure;

public class EmailLogGateway {

    public void push(EmailData data) {
        System.out.println("SendEmail to " + data.getEmail());
    }
}
