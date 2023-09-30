package fr.gboissinot.al.account.step17.application.services;

import fr.gboissinot.al.account.step17.application.events.AccountCreatedEvent;
import fr.gboissinot.al.account.step17.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step17.application.port.out.CreateAccountPort;
import fr.gboissinot.al.account.step17.domain.Account;
import fr.gboissinot.al.account.step17.domain.Money;
import fr.gboissinot.al.kernel.CommandHandler;
import fr.gboissinot.al.kernel.Event;
import fr.gboissinot.al.kernel.EventDispatcher;

public final class CreateAccountService implements CommandHandler<CreateAccountCommand, String> {

    private final CreateAccountPort createAccountPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateAccountService(CreateAccountPort createAccountPort, EventDispatcher<? super Event> eventDispatcher) {
        this.createAccountPort = createAccountPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var initialMoney = Money.of(command.initialMoney);
        var account = new Account(accountId, initialMoney);
        createAccountPort.save(account);
        eventDispatcher.dispatch(new AccountCreatedEvent(accountId, initialMoney));
        return accountId.value();
    }
}
