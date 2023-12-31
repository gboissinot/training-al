package fr.gboissinot.al.account.step9.application.services;

import fr.gboissinot.al.account.step9.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step9.application.port.in.CreateAccountUseCase;
import fr.gboissinot.al.account.step9.application.port.out.CreateAccountPort;
import fr.gboissinot.al.account.step9.domain.Account;
import fr.gboissinot.al.account.step9.domain.AccountId;

public class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public AccountId createAccount(CreateAccountCommand createAccountCommand) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, createAccountCommand.initialMoney);
        createAccountPort.save(account);
        return accountId;
    }
}
