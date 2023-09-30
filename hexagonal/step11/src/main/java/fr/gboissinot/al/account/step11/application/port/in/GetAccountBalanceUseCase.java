package fr.gboissinot.al.account.step11.application.port.in;

import fr.gboissinot.al.account.step11.domain.Money;
import fr.gboissinot.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Money> {
}
