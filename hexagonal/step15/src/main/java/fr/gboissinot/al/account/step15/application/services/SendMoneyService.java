package fr.gboissinot.al.account.step15.application.services;

import fr.gboissinot.al.account.step15.application.AccountApplicationException;
import fr.gboissinot.al.account.step15.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step15.application.port.out.LoadAccountPort;
import fr.gboissinot.al.account.step15.application.port.out.UpdateAccountStatePort;
import fr.gboissinot.al.account.step15.domain.AccountConfiguration;
import fr.gboissinot.al.account.step15.domain.AccountId;
import fr.gboissinot.al.account.step15.domain.Money;
import fr.gboissinot.al.kernel.CommandHandler;

import java.util.UUID;

public final class SendMoneyService implements CommandHandler<SendMoneyCommand, Void> {

    private final AccountConfiguration accountConfiguration;
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;

    public SendMoneyService(AccountConfiguration accountConfiguration, LoadAccountPort loadAccountPort, UpdateAccountStatePort updateAccountStatePort) {
        this.accountConfiguration = accountConfiguration;
        this.loadAccountPort = loadAccountPort;
        this.updateAccountStatePort = updateAccountStatePort;
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

        return null;
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
