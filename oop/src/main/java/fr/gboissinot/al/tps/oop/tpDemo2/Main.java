package fr.gboissinot.al.tps.oop.tpDemo2;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LoggerFactory.createFileLogger("/users/gboissinot/log");
        logger.log("My Message");

    }
}
