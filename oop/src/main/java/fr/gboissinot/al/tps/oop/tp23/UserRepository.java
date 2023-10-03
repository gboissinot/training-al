package fr.gboissinot.al.tps.oop.tp23;

interface UserRepository {

    User getById(UserId id);

    void save(User user);
}
