package fr.gboissinot.al.account.step12.application.port.in;

import fr.gboissinot.al.account.step12.domain.AccountId;
import fr.gboissinot.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
