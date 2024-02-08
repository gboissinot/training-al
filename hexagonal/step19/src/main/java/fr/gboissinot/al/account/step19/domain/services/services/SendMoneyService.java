package fr.gboissinot.al.account.step19.domain.services.services;

import fr.gboissinot.al.account.step19.domain.services.AccountApplicationException;
import fr.gboissinot.al.account.step19.domain.services.SendMoneyCommand;
import fr.gboissinot.al.account.step19.domain.services.events.TransferAcceptedApplicationEvent;
import fr.gboissinot.al.account.step19.domain.model.AccountConfiguration;
import fr.gboissinot.al.account.step19.domain.model.AccountId;
import fr.gboissinot.al.account.step19.domain.model.Accounts;
import fr.gboissinot.al.account.step19.domain.model.Money;
import fr.gboissinot.al.kernel.CommandHandler;
import fr.gboissinot.al.kernel.Event;
import fr.gboissinot.al.kernel.EventDispatcher;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public class SendMoneyService implements CommandHandler<SendMoneyCommand, Void> {

    private final AccountConfiguration accountConfiguration;
    private final Accounts accounts;
    private final EventDispatcher<? super Event> eventDispatcher;

    public SendMoneyService(AccountConfiguration accountConfiguration, Accounts accounts, EventDispatcher<? super Event> eventDispatcher) {
        this.accountConfiguration = accountConfiguration;
        this.accounts = accounts;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Void handle(SendMoneyCommand sendMoneyCommand) {

        var sourceAccountId = AccountId.of(UUID.fromString(sendMoneyCommand.sourceAccountId));
        var targetAccountId = AccountId.of(UUID.fromString(sendMoneyCommand.targetAccountId));
        var amount = Money.of(sendMoneyCommand.amount);
        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.exceededThreshold(sourceAccountId, targetAccountId, amount);
        }

        var sourceAccount = accounts.findById(sourceAccountId);
        var targetAccount = accounts.findById(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accounts.add(sourceAccount);
        accounts.add(targetAccount);

        eventDispatcher.dispatch(new TransferAcceptedApplicationEvent(sourceAccountId, targetAccountId, amount));

        return null;
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
