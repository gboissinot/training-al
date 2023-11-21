package fr.gboissinot.al.tps.oop.tp14;

final class MySQLUserPersistence implements UserPersistence {
    @Override
    public void create(User user) {
        System.out.println("MYSQL Creation with " + user);
    }
}
