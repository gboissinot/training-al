package fr.gboissinot.al.account.step19.application.services;

import fr.gboissinot.al.account.step19.application.AccountBalanceQuery;
import fr.gboissinot.al.account.step19.domain.AccountId;
import fr.gboissinot.al.account.step19.domain.Accounts;
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
