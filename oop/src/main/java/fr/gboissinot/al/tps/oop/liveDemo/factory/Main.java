package fr.gboissinot.al.tps.oop.liveDemo.factory;

import fr.gboissinot.al.tps.oop.liveDemo.factory.logger.LoggerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        var logger = LoggerFactory.createFileLogger("/Users/gboissinot/esgi/esgi-log.txt");
        logger.log("My message");
    }
}
