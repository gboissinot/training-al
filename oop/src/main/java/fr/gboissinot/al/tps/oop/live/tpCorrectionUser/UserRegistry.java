package fr.gboissinot.al.tps.oop.live.tpCorrectionUser;

public interface UserRegistry {
    void save(User user);
    User getById(int id);
}
