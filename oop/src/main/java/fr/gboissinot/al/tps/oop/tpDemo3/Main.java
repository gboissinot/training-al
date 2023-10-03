package fr.gboissinot.al.tps.oop.tpDemo3;

import fr.gboissinot.al.tps.oop.tpDemo3.domain.MyService;
import fr.gboissinot.al.tps.oop.tpDemo3.domain.User;
import fr.gboissinot.al.tps.oop.tpDemo3.infrastructure.MySQLUserDao;

public class Main {

    public static void main(String[] args) {
        var service = new MyService(new MySQLUserDao());
        service.addUser(new User());
    }
}
