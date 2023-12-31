package fr.gboissinot.al.account.step13;

import fr.gboissinot.al.account.step13.adapter.out.AccountPersistenceAdapter;
import fr.gboissinot.al.account.step13.application.port.in.*;
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
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountBalanceUseCase accountBalanceUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, AccountPersistenceAdapter persistenceAdapter, CreateAccountUseCase createAccountUseCase, GetAccountBalanceUseCase accountBalanceUseCase, SendMoneyUseCase sendMoneyUseCase) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.createAccountUseCase = createAccountUseCase;
        this.accountBalanceUseCase = accountBalanceUseCase;
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(SendMoneyCommand.class, sendMoneyUseCase);
        commandBus.register(CreateAccountCommand.class, createAccountUseCase);
        queryBus.register(AccountBalanceQuery.class, accountBalanceUseCase);
    }
}
