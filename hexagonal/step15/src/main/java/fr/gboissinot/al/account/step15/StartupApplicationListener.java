package fr.gboissinot.al.account.step15;

import fr.gboissinot.al.account.step15.adapter.out.AccountPersistenceAdapter;
import fr.gboissinot.al.account.step15.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step15.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step15.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step15.application.services.CreateAccountService;
import fr.gboissinot.al.account.step15.application.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step15.application.services.SendMoneyService;
import fr.gboissinot.al.kernel.CommandBus;
import fr.gboissinot.al.kernel.QueryBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final AccountPersistenceAdapter persistenceAdapter;
    private final CreateAccountService createAccountService;
    private final GetAccountBalanceService accountBalanceService;
    private final SendMoneyService sendMoneyService;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, AccountPersistenceAdapter persistenceAdapter, CreateAccountService createAccountService, GetAccountBalanceService accountBalanceService, SendMoneyService sendMoneyService) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.createAccountService = createAccountService;
        this.accountBalanceService = accountBalanceService;
        this.sendMoneyService = sendMoneyService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(SendMoneyCommand.class, sendMoneyService);
        commandBus.register(CreateAccountCommand.class, createAccountService);
        queryBus.register(AccountBalanceQuery.class, accountBalanceService);
    }
}
