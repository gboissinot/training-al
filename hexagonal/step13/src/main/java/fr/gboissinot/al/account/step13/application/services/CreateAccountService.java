package fr.gboissinot.al.account.step13.application.services;

import fr.gboissinot.al.account.step13.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step13.application.port.in.CreateAccountUseCase;
import fr.gboissinot.al.account.step13.application.port.out.CreateAccountPort;
import fr.gboissinot.al.account.step13.domain.Account;
import fr.gboissinot.al.account.step13.domain.AccountId;

public final class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public AccountId handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, command.initialMoney);
        createAccountPort.save(account);
        return accountId;
    }
}
