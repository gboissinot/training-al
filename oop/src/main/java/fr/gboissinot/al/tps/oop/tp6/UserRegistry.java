package fr.gboissinot.al.tps.oop.tp6;

interface UserRegistry {
    User getById(String id);

    void save(User user);
}
