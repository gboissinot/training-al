package fr.gboissinot.al.tps.oop.livreDemo.notification.domain;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model.User;

//Infrastructure service
public interface Notifications {
    void send(User user);
}
