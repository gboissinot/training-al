package fr.gboissinot.al.account.step18.application.services;

import fr.gboissinot.al.account.step18.application.AccountApplicationException;
import fr.gboissinot.al.account.step18.application.events.TransferAcceptedApplicationEvent;
import fr.gboissinot.al.account.step18.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step18.application.port.out.LoadAccountPort;
import fr.gboissinot.al.account.step18.application.port.out.UpdateAccountStatePort;
import fr.gboissinot.al.account.step18.domain.AccountConfiguration;
import fr.gboissinot.al.account.step18.domain.AccountId;
import fr.gboissinot.al.account.step18.domain.Money;
import fr.gboissinot.al.kernel.CommandHandler;
import fr.gboissinot.al.kernel.Event;
import fr.gboissinot.al.kernel.EventDispatcher;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public class SendMoneyService implements CommandHandler<SendMoneyCommand, Void> {

    private final AccountConfiguration accountConfiguration;
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public SendMoneyService(AccountConfiguration accountConfiguration, LoadAccountPort loadAccountPort, UpdateAccountStatePort updateAccountStatePort, EventDispatcher<? super Event> eventDispatcher) {
        this.accountConfiguration = accountConfiguration;
        this.loadAccountPort = loadAccountPort;
        this.updateAccountStatePort = updateAccountStatePort;
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

        var sourceAccount = loadAccountPort.load(sourceAccountId);
        var targetAccount = loadAccountPort.load(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        updateAccountStatePort.update(sourceAccount);
        updateAccountStatePort.update(targetAccount);

        eventDispatcher.dispatch(new TransferAcceptedApplicationEvent(sourceAccountId, targetAccountId, amount));

        return null;
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
