package fr.gboissinot.al.account.step19;

import fr.gboissinot.al.account.step19.domain.services.AccountBalanceQuery;
import fr.gboissinot.al.account.step19.domain.services.CreateAccountCommand;
import fr.gboissinot.al.account.step19.domain.services.SendMoneyCommand;
import fr.gboissinot.al.account.step19.domain.services.events.AccountCreatedApplicationEvent;
import fr.gboissinot.al.account.step19.domain.services.events.AccountCreatedEventHandler;
import fr.gboissinot.al.account.step19.domain.services.events.TransferAcceptedApplicationEvent;
import fr.gboissinot.al.account.step19.domain.services.events.TransferAcceptedEventHandler;
import fr.gboissinot.al.account.step19.domain.services.services.CreateAccountService;
import fr.gboissinot.al.account.step19.domain.services.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step19.domain.services.services.SendMoneyService;
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

        eventDispatcher.register(TransferAcceptedApplicationEvent.class, transferAcceptedEventHandler);
        eventDispatcher.register(AccountCreatedApplicationEvent.class, accountCreatedEventHandler);

        commandBus.register(SendMoneyCommand.class, sendMoneyService);
        commandBus.register(CreateAccountCommand.class, createAccountService);
        queryBus.register(AccountBalanceQuery.class, accountBalanceService);
    }
}
