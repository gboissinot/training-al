package fr.gboissinot.al.account.step19.domain.services.services;

import fr.gboissinot.al.account.step19.domain.services.CreateAccountCommand;
import fr.gboissinot.al.account.step19.domain.services.events.AccountCreatedApplicationEvent;
import fr.gboissinot.al.account.step19.domain.model.Account;
import fr.gboissinot.al.account.step19.domain.model.Accounts;
import fr.gboissinot.al.account.step19.domain.model.Money;
import fr.gboissinot.al.kernel.CommandHandler;
import fr.gboissinot.al.kernel.Event;
import fr.gboissinot.al.kernel.EventDispatcher;

public final class CreateAccountService implements CommandHandler<CreateAccountCommand, String> {

    private final Accounts accounts;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateAccountService(Accounts accounts, EventDispatcher<? super Event> eventDispatcher) {
        this.accounts = accounts;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateAccountCommand command) {
        var accountId = accounts.nextId();
        var initialMoney = Money.of(command.initialMoney);
        var account = new Account(accountId, initialMoney);
        accounts.add(account);
        eventDispatcher.dispatch(new AccountCreatedApplicationEvent(accountId, initialMoney));
        return accountId.value();
    }
}
