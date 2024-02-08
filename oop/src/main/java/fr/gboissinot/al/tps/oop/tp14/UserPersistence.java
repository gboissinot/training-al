package fr.gboissinot.al.tps.oop.tp14;

interface UserPersistence {

     User getById(String id);

    void save(User user);
}
