package fr.gboissinot.al.account.step11.application.port.in;

import fr.gboissinot.al.account.step11.domain.AccountId;
import fr.gboissinot.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
