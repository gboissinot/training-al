package fr.gboissinot.al.account.step16;

import fr.gboissinot.al.account.step16.adapter.in.AccountController;
import fr.gboissinot.al.account.step16.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.gboissinot.al.account.step16.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step16.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step16.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step16.application.services.CreateAccountService;
import fr.gboissinot.al.account.step16.application.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step16.application.services.SendMoneyService;
import fr.gboissinot.al.account.step16.domain.AccountConfiguration;
import fr.gboissinot.al.kernel.BusFactory;

public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var persistenceAdapter = new InMemoryAccountPersistenceAdapter();
        var createAccountPort = persistenceAdapter;
        var loadAccountPort = persistenceAdapter;
        var updateAccountStatePort = persistenceAdapter;

        var createAccountService = new CreateAccountService(createAccountPort);
        var sendMoneyService = new SendMoneyService(accountConfiguration, loadAccountPort, updateAccountStatePort);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(SendMoneyCommand.class, sendMoneyService);
        commandBus.register(CreateAccountCommand.class, createAccountService);

        var queryBus = BusFactory.defaultQueryBus();
        var accountBalanceService = new GetAccountBalanceService(loadAccountPort);
        queryBus.register(AccountBalanceQuery.class, accountBalanceService);

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
