package fr.gboissinot.al.account.step3.application;

import fr.gboissinot.al.account.step3.domain.AccountId;
import fr.gboissinot.al.account.step3.domain.Money;

public final class AccountApplicationException extends RuntimeException {

    private AccountApplicationException(String message) {
        super(message);
    }

    public static AccountApplicationException exceededThreshold(AccountId accountId1, AccountId accountId2, Money money) {
        return new AccountApplicationException(String.format("[account1=%s,account2=%s,balance=%,.2f] transfer cannot be executed.",
                accountId1.value(),
                accountId2.value(),
                money.value()));
    }

    public static AccountApplicationException wrongTransferMoney(Money money) {
        return new AccountApplicationException(String.format("The transfer amount must be positive value. Given value %s", money.value()));
    }
}
