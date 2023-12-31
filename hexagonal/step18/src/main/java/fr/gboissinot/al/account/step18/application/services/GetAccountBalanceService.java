package fr.gboissinot.al.account.step18.application.services;

import fr.gboissinot.al.account.step18.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step18.application.port.out.LoadAccountPort;
import fr.gboissinot.al.account.step18.domain.AccountId;
import fr.gboissinot.al.kernel.QueryHandler;

import java.util.UUID;

public final class GetAccountBalanceService implements QueryHandler<AccountBalanceQuery, Double> {

    private final LoadAccountPort loadAccountPort;

    public GetAccountBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    @Override
    public Double handle(AccountBalanceQuery query) {
        var account = loadAccountPort.load(AccountId.of(UUID.fromString(query.accountId)));
        var accountReadModel = AccountReadModel.from(account);
        return accountReadModel.balance().value();
    }
}
