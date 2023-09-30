package fr.gboissinot.al.account.step14;

import fr.gboissinot.al.account.step14.adapter.in.AccountController;
import fr.gboissinot.al.account.step14.adapter.out.AccountPersistenceAdapter;
import fr.gboissinot.al.account.step14.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step14.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step14.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step14.application.services.CreateAccountService;
import fr.gboissinot.al.account.step14.application.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step14.application.services.SendMoneyService;
import fr.gboissinot.al.account.step14.domain.AccountConfiguration;
import fr.gboissinot.al.kernel.BusFactory;

public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var persistenceAdapter = new AccountPersistenceAdapter();
        var createAccountPort = persistenceAdapter;
        var loadAccountPort = persistenceAdapter;
        var updateAccountStatePort = persistenceAdapter;

        var createAccountUseCase = new CreateAccountService(createAccountPort);
        var sendMoneyUseCase = new SendMoneyService(accountConfiguration, loadAccountPort, updateAccountStatePort);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(SendMoneyCommand.class, sendMoneyUseCase);
        commandBus.register(CreateAccountCommand.class, createAccountUseCase);

        var queryBus = BusFactory.defaultQueryBus();
        var accountBalanceUseCase = new GetAccountBalanceService(loadAccountPort);
        queryBus.register(AccountBalanceQuery.class, accountBalanceUseCase);

        var accountController = new AccountController(commandBus, queryBus);

        var accountId1 = accountController.create(250);
        var accountId2 = accountController.create(50);

        accountController.transfer(accountId1, accountId2, 50);

        var newLoadedAccount1 = accountController.getBalance(accountId1);
        var newLoadedAccount2 = accountController.getBalance(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}
