package fr.gboissinot.al.account.step7.application.port.in;

import fr.gboissinot.al.account.step7.domain.AccountId;

public interface CreateAccountUseCase {
    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
