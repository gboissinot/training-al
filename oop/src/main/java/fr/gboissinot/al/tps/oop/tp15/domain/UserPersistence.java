package fr.gboissinot.al.tps.oop.tp15.domain;

import fr.gboissinot.al.tps.oop.tp15.domain.model.User;

public interface UserPersistence {
    User getById(String id);

    void save(User user);
}
