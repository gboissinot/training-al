package fr.gboissinot.al.account.step10.application.services;

import fr.gboissinot.al.account.step10.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step10.application.port.in.GetAccountBalanceUseCase;
import fr.gboissinot.al.account.step10.application.port.out.LoadAccountPort;
import fr.gboissinot.al.account.step10.domain.Money;

public final class GetAccountBalanceService implements GetAccountBalanceUseCase {

    private final LoadAccountPort loadAccountPort;

    public GetAccountBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    @Override
    public Money balance(AccountBalanceQuery balanceQuery) {
        var account = loadAccountPort.load(balanceQuery.accountId);
        return account.balance();
    }
}
