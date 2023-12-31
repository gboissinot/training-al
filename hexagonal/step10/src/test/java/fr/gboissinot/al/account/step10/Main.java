package fr.gboissinot.al.account.step10;

import fr.gboissinot.al.account.step10.adapter.in.AccountController;
import fr.gboissinot.al.account.step10.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.gboissinot.al.account.step10.application.services.CreateAccountService;
import fr.gboissinot.al.account.step10.application.services.GetAccountBalanceService;
import fr.gboissinot.al.account.step10.application.services.SendMoneyService;
import fr.gboissinot.al.account.step10.domain.AccountConfiguration;
import fr.gboissinot.al.account.step10.domain.Money;

public class Main {
    public static void main(String[] args) {
        var persistenceAdapter = new InMemoryAccountPersistenceAdapter();
        var accountController =
                new AccountController(
                        new CreateAccountService(persistenceAdapter),
                        new SendMoneyService(new AccountConfiguration(5000), persistenceAdapter, persistenceAdapter),
                        new GetAccountBalanceService(persistenceAdapter));

        var accountId = accountController.create(Money.of(50));
        var balance = accountController.getBalance(accountId);
        System.out.println(balance);
    }
}
