package fr.gboissinot.al.account.step3.application.services;

import fr.gboissinot.al.account.step3.application.AccountApplicationException;
import fr.gboissinot.al.account.step3.application.port.out.AccountRepository;
import fr.gboissinot.al.account.step3.domain.AccountConfiguration;
import fr.gboissinot.al.account.step3.domain.AccountId;
import fr.gboissinot.al.account.step3.domain.Money;

import java.util.Objects;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public void sendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {

        checkInput(sourceAccountId, targetAccountId, amount);

        var sourceAccount = accountRepository.findById(sourceAccountId);
        var targetAccount = accountRepository.findById(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private void checkInput(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        Objects.requireNonNull(sourceAccountId);
        Objects.requireNonNull(targetAccountId);
        Objects.requireNonNull(amount);
        if (!amount.isPositive()) {
            throw AccountApplicationException.wrongTransferMoney(amount);
        }

        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.exceededThreshold(sourceAccountId, targetAccountId, amount);
        }
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
