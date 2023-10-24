package fr.gboissinot.al.tps.oop.tp5;

import fr.gboissinot.al.tps.oop.tp5.logger.LoggerFactory;

public class Main {
    public static void main(String[] args) throws Exception {

//        Sample reflexion
//        final Constructor<?>[] constructors = ServiceLocator.class.getDeclaredConstructors();
//        for (Constructor<?> constructor : constructors) {
//            constructor.setAccessible(true);
//            constructor.newInstance(new Object[0]);
//        }


        var logger = LoggerFactory.createFileLogger("/Users/gboissinot/esgi/esgi-log.txt");
        logger.log("My message");

    }
}
