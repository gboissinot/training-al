package fr.gboissinot.al.account.step19.application.events;

import fr.gboissinot.al.account.step19.domain.AccountId;
import fr.gboissinot.al.account.step19.domain.Money;
import fr.gboissinot.al.kernel.Event;

public class AccountCreatedApplicationEvent implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountCreatedApplicationEvent(AccountId accountId, Money amount) {
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
