package fr.gboissinot.al.account.step14.application.port.in;

import fr.gboissinot.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Double> {
}
