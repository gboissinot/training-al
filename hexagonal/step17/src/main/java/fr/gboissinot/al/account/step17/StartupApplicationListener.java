package fr.gboissinot.al.account.step17;

import fr.gboissinot.al.account.step17.application.events.AccountCreatedEvent;
import fr.gboissinot.al.account.step17.application.events.TransferAcceptedEvent;
import fr.gboissinot.al.account.step17.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step17.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step17.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step17.application.services.*;
import fr.gboissinot.al.kernel.CommandBus;
import fr.gboissinot.al.kernel.EventDispatcher;
import fr.gboissinot.al.kernel.QueryBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final CreateAccountService createAccountService;
    private final GetAccountBalanceService accountBalanceService;
    private final SendMoneyService sendMoneyService;
    private final EventDispatcher eventDispatcher;
    private final TransferAcceptedEventHandler transferAcceptedEventHandler;
    private final AccountCreatedEventHandler accountCreatedEventHandler;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, CreateAccountService createAccountService, GetAccountBalanceService accountBalanceService, SendMoneyService sendMoneyService, EventDispatcher eventDispatcher, TransferAcceptedEventHandler transferAcceptedEventHandler, AccountCreatedEventHandler accountCreatedEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.createAccountService = createAccountService;
        this.accountBalanceService = accountBalanceService;
        this.sendMoneyService = sendMoneyService;
        this.eventDispatcher = eventDispatcher;
        this.transferAcceptedEventHandler = transferAcceptedEventHandler;
        this.accountCreatedEventHandler = accountCreatedEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        eventDispatcher.register(TransferAcceptedEvent.class, transferAcceptedEventHandler);
        eventDispatcher.register(AccountCreatedEvent.class, accountCreatedEventHandler);

        commandBus.register(SendMoneyCommand.class, sendMoneyService);
        commandBus.register(CreateAccountCommand.class, createAccountService);
        queryBus.register(AccountBalanceQuery.class, accountBalanceService);
    }
}
