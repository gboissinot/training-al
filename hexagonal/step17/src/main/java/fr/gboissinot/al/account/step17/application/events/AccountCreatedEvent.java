package fr.gboissinot.al.account.step17.application.events;

import fr.gboissinot.al.account.step17.domain.AccountId;
import fr.gboissinot.al.account.step17.domain.Money;
import fr.gboissinot.al.kernel.Event;

public class AccountCreatedEvent implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountCreatedEvent(AccountId accountId, Money amount) {
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
