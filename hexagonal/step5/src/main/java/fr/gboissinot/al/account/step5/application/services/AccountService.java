package fr.gboissinot.al.account.step5.application.services;

import fr.gboissinot.al.account.step5.application.AccountApplicationException;
import fr.gboissinot.al.account.step5.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step5.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step5.application.port.out.AccountRepository;
import fr.gboissinot.al.account.step5.domain.Account;
import fr.gboissinot.al.account.step5.domain.AccountConfiguration;
import fr.gboissinot.al.account.step5.domain.AccountId;
import fr.gboissinot.al.account.step5.domain.Money;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public AccountId createAccount(CreateAccountCommand createAccountCommand) {
        var accountId = accountRepository.nextId();
        var account = new Account(accountId, createAccountCommand.initialMoney);
        accountRepository.save(account);
        return accountId;
    }

    public void sendMoney(SendMoneyCommand sendMoneyCommand) {
        var sourceAccountId = sendMoneyCommand.sourceAccountId;
        var targetAccountId = sendMoneyCommand.targetAccountId;
        var amount = sendMoneyCommand.amount;
        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.exceededThreshold(sourceAccountId, targetAccountId, amount);
        }

        var sourceAccount = accountRepository.findById(sourceAccountId);
        var targetAccount = accountRepository.findById(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
