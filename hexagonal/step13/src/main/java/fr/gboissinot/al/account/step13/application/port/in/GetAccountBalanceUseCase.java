package fr.gboissinot.al.account.step13.application.port.in;

import fr.gboissinot.al.account.step13.domain.Money;
import fr.gboissinot.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Money> {
}
