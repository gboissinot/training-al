package fr.gboissinot.al.account.step10.application.port.in;

import fr.gboissinot.al.account.step10.domain.AccountId;

public interface CreateAccountUseCase {
    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
