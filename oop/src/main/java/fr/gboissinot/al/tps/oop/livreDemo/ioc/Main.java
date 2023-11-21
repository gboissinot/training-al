package fr.gboissinot.al.tps.oop.livreDemo.ioc;

import fr.gboissinot.al.tps.oop.livreDemo.ioc.donain.Service;

public class Main {
    public static void main(String[] args) {
        final Service service = Container.getService();
        service.myMethod();
    }
}
