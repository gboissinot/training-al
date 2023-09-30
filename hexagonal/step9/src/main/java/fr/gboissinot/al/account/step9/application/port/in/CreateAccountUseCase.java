package fr.gboissinot.al.account.step9.application.port.in;

import fr.gboissinot.al.account.step9.domain.AccountId;

public interface CreateAccountUseCase {
    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
