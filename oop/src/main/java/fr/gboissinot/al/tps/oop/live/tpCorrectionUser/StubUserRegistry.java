package fr.gboissinot.al.tps.oop.live.tpCorrectionUser;

import java.util.HashMap;
import java.util.Map;

public class StubUserRegistry implements UserRegistry {

    private final Map<Integer, User> inMemoryDB = new HashMap<>();

    public StubUserRegistry() {
    }


    @Override
    public void save(User user) {
        inMemoryDB.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        return inMemoryDB.get(id);
    }
}
