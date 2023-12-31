package fr.gboissinot.al.account.step16.application.services;

import fr.gboissinot.al.account.step16.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step16.application.port.out.CreateAccountPort;
import fr.gboissinot.al.account.step16.domain.Account;
import fr.gboissinot.al.account.step16.domain.Money;
import fr.gboissinot.al.kernel.CommandHandler;

public final class CreateAccountService implements CommandHandler<CreateAccountCommand, String> {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public String handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, Money.of(command.initialMoney));
        createAccountPort.save(account);
        return accountId.value();
    }
}
