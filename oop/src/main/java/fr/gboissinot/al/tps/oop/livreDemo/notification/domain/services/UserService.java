package fr.gboissinot.al.tps.oop.livreDemo.notification.domain.services;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.Notifications;
import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.Users;
import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model.Email;
import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model.User;

//Application service
public final class UserService {

    private final Users users;
    private final Notifications notifications;

    public UserService(Users users, Notifications notifications) {
        this.users = users;
        this.notifications = notifications;
    }

    public void create(String lastname, String firstname, String email) {
        var userId = users.nextId();
        var user = new User(userId, lastname, firstname, Email.of(email));
        users.add(user);
        notifications.send(user);
    }

    public void changeUser(String userId, String newLastName) {
        var user = users.getById(userId);
        user.changeLastName(newLastName);
        users.add(user);
    }
}
