package fr.gboissinot.al.tps.oop.livreDemo.ioc.donain;

public class Service {

    //Use the DIP Pattern
    private final AbstractPersistence persistence;

    //Use the DI pattern
    public Service(AbstractPersistence persistence) {
        this.persistence = persistence;
    }

    public void myMethod() {
        persistence.m();
    }
}
