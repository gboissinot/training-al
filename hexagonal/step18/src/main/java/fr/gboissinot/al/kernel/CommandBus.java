package fr.gboissinot.al.kernel;

public interface CommandBus<C extends Command> {
    <R> R post(C command);

    <R> void register(Class<C> commandClass, CommandHandler<C, R> commandHandler);
}
