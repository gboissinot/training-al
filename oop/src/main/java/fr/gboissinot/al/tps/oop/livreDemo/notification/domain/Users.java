package fr.gboissinot.al.tps.oop.livreDemo.notification.domain;

import fr.gboissinot.al.tps.oop.livreDemo.notification.domain.model.User;

//Repository
public interface Users {

    String nextId();

    void add(User user);

    void delete(User user);

    User getById(String id);
}
