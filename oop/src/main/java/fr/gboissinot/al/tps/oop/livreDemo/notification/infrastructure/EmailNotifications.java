package fr.gboissinot.al.tps.oop.livreDemo.notification.infrastructure;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.Notifications;
import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model.User;

//Infrastructure service implementation
public class EmailNotifications implements Notifications {

    private final EmailLogGateway emailLogGateway;

    public EmailNotifications(EmailLogGateway emailLogGateway) {
        this.emailLogGateway = emailLogGateway;
    }

    @Override
    public void send(User user) {
        EmailData emailData = new EmailData(user.getEmail().value());
        emailLogGateway.push(emailData);
    }
}
