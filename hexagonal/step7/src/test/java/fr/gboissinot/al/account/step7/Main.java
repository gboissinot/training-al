package fr.gboissinot.al.account.step7;

import fr.gboissinot.al.account.step7.adapter.in.AccountController;
import fr.gboissinot.al.account.step7.adapter.out.InMemoryAccountRepository;
import fr.gboissinot.al.account.step7.application.services.CreateAccountService;
import fr.gboissinot.al.account.step7.application.services.SendMoneyService;
import fr.gboissinot.al.account.step7.domain.AccountConfiguration;
import fr.gboissinot.al.account.step7.domain.Money;

public class Main {

    public static void main(String[] args) {

        var accountRepository = new InMemoryAccountRepository();
        var createAccountService = new CreateAccountService(accountRepository);
        var accountConfiguration = new AccountConfiguration(1000L);
        var sendMoneyService = new SendMoneyService(accountConfiguration, accountRepository);
        var createAccountUseCase = createAccountService;
        var sendMoneyUseCase = sendMoneyService;
        var accountController = new AccountController(createAccountUseCase, sendMoneyUseCase);

        var accountId1 = accountController.create(Money.of(250));
        var accountId2 = accountController.create(Money.of(50));

        accountController.transfer(accountId1, accountId2, Money.of(50));

        var newLoadedAccount1 = accountRepository.findById(accountId1);
        var newLoadedAccount2 = accountRepository.findById(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}
