package fr.gboissinot.al.tps.oop.tp16.domain;

import fr.gboissinot.al.tps.oop.tp16.domain.model.User;

//Repository
public interface Users {

    String nextId();

    void add(User user);

    void delete(User user);

    User getById(String id);
}
