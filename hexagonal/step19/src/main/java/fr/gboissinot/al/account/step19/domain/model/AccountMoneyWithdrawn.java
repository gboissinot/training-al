package fr.gboissinot.al.account.step19.domain.model;

import fr.gboissinot.al.kernel.Event;

public class AccountMoneyWithdrawn implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountMoneyWithdrawn(AccountId accountId, Money amount) {
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
