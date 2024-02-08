package fr.gboissinot.al.account.step19.domain.services.events;

import fr.gboissinot.al.account.step19.domain.model.AccountId;
import fr.gboissinot.al.account.step19.domain.model.Money;
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
