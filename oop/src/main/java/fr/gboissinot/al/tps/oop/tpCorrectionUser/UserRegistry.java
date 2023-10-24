package fr.gboissinot.al.tps.oop.tpCorrectionUser;

public interface UserRegistry {
    void save(User user);
    User getById(int id);
}
