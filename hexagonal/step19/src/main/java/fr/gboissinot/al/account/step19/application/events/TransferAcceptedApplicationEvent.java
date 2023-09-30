package fr.gboissinot.al.account.step19.application.events;

import fr.gboissinot.al.account.step19.domain.AccountId;
import fr.gboissinot.al.account.step19.domain.Money;
import fr.gboissinot.al.kernel.Event;

public final class TransferAcceptedApplicationEvent implements Event {

    private final AccountId sourceAccountId;
    private final AccountId targetAccountId;
    private final Money amount;

    public TransferAcceptedApplicationEvent(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }

    public AccountId getSourceAccountId() {
        return sourceAccountId;
    }

    public AccountId getTargetAccountId() {
        return targetAccountId;
    }

    public Money getAmount() {
        return amount;
    }
}
