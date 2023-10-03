package fr.gboissinot.al.tps.oop.tp5;

final class ServiceLocatorSingleton {

    private static final ServiceLocatorSingleton INSTANCE = new ServiceLocatorSingleton();

    private ServiceLocatorSingleton() {
    }

    public static ServiceLocatorSingleton getInstance() {
        return INSTANCE;
    }
}
