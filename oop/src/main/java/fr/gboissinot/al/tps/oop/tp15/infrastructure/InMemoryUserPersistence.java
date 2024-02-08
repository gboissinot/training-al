package fr.gboissinot.al.tps.oop.tp15.infrastructure;

import fr.gboissinot.al.tps.oop.tp15.domain.UserPersistence;
import fr.gboissinot.al.tps.oop.tp15.domain.model.User;

import java.util.HashMap;
import java.util.Map;

public final class InMemoryUserPersistence implements UserPersistence {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public User getById(String id) {
        return users.get(id);
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }
}
