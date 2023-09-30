package fr.gboissinot.al.account.step10.application.port.in;

import fr.gboissinot.al.account.step10.domain.AccountId;
import fr.gboissinot.al.kernel.Query;

import javax.validation.constraints.NotNull;

public final class AccountBalanceQuery implements Query {

    @NotNull
    public final AccountId accountId;

    public AccountBalanceQuery(AccountId accountId) {
        this.accountId = accountId;
        validate(this);
    }
}
