package fr.gboissinot.al.account.step19.domain.services.services;

import fr.gboissinot.al.account.step19.domain.services.AccountBalanceQuery;
import fr.gboissinot.al.account.step19.domain.model.AccountId;
import fr.gboissinot.al.account.step19.domain.model.Accounts;
import fr.gboissinot.al.kernel.QueryHandler;

import java.util.UUID;

public final class GetAccountBalanceService implements QueryHandler<AccountBalanceQuery, Double> {

    private final Accounts accounts;

    public GetAccountBalanceService(Accounts accounts) {
        this.accounts = accounts;
    }

    @Override
    public Double handle(AccountBalanceQuery query) {
        var account = accounts.findById(AccountId.of(UUID.fromString(query.accountId)));
        var accountReadModel = AccountReadModel.from(account);
        return accountReadModel.balance().value();
    }
}
