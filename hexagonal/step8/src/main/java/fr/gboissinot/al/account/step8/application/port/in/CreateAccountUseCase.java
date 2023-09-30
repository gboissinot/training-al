package fr.gboissinot.al.account.step8.application.port.in;

import fr.gboissinot.al.account.step8.domain.AccountId;

public interface CreateAccountUseCase {
    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
