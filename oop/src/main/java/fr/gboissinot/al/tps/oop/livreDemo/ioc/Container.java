package fr.gboissinot.al.tps.oop.livreDemo.ioc;

import fr.gboissinot.al.tps.oop.livreDemo.ioc.donain.Service;
import fr.gboissinot.al.tps.oop.livreDemo.ioc.infrastructure.PersisteImpl;

public class Container {

    //IOC Pattern
    public static Service getService() {
        var persistence = new PersisteImpl();
        return new Service(persistence);
    }
}
