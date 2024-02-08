package fr.gboissinot.al.tps.oop.tp6;

interface UserPersistence {
    User getById(String id);

    void save(User user);
}
