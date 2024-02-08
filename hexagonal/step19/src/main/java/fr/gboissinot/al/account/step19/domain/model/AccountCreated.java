package fr.gboissinot.al.account.step19.domain.model;

import fr.gboissinot.al.kernel.Event;

public class AccountCreated implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountCreated(AccountId accountId, Money amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Money getAmount() {
        return amount;
    }
}
