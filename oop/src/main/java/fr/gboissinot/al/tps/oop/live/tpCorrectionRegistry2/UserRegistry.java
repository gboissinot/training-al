package fr.gboissinot.al.tps.oop.live.tpCorrectionRegistry2;

public interface UserRegistry {

    void save(User user);

    User getById(String id);
}
