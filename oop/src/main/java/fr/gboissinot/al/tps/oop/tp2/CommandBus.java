package fr.gboissinot.al.tps.oop.tp2;

interface CommandBus {
    default void dispatch(Command command) {
        long startime = System.currentTimeMillis();
        execute(command);
        long endtime = System.currentTimeMillis();
        System.out.println(String.format("Command '%s' executed in %d ms.", command.name(), (endtime - startime)));
    }

    void execute(Command command);

}
