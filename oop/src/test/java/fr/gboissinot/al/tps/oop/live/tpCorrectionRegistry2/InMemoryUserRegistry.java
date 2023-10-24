package fr.gboissinot.al.tps.oop.live.tpCorrectionRegistry2;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRegistry implements UserRegistry {

    private final Map<String, User> inMemoryMap = new HashMap<>();

    @Override
    public void save(User user) {
        inMemoryMap.put(user.getId(), user);
    }

    @Override
    public User getById(String id) {
        return inMemoryMap.get(id);
    }

}
