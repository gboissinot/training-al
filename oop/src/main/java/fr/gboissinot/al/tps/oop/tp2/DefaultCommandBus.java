package fr.gboissinot.al.tps.oop.tp2;


final class DefaultCommandBus implements CommandBus {
    @Override
    public void execute(Command command) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
