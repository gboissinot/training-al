package fr.gboissinot.al.account.step19.domain.services;

import fr.gboissinot.al.kernel.Query;

import javax.validation.constraints.NotNull;

public final class AccountBalanceQuery implements Query {

    @NotNull
    public final String accountId;

    public AccountBalanceQuery(String accountId) {
        this.accountId = accountId;
    }
}
