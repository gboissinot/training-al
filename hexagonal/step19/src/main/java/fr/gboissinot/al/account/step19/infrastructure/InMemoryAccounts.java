package fr.gboissinot.al.account.step19.infrastructure;

import fr.gboissinot.al.account.step19.domain.model.Account;
import fr.gboissinot.al.account.step19.domain.model.AccountException;
import fr.gboissinot.al.account.step19.domain.model.AccountId;
import fr.gboissinot.al.account.step19.domain.model.Accounts;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class InMemoryAccounts implements Accounts {

    private final Map<AccountId, Account> registry = new HashMap<>();

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void add(Account account) {
        registry.put(account.id(), account);
    }

    @Override
    public Account findById(AccountId accountId) {
        return registry.computeIfAbsent(accountId,
                key -> {
                    throw AccountException.notFoundAccountId(accountId);
                });
    }
}