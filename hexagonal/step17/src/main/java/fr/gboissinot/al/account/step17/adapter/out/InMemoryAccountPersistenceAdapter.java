package fr.gboissinot.al.account.step17.adapter.out;

import fr.gboissinot.al.account.step17.application.port.out.CreateAccountPort;
import fr.gboissinot.al.account.step17.application.port.out.LoadAccountPort;
import fr.gboissinot.al.account.step17.application.port.out.UpdateAccountStatePort;
import fr.gboissinot.al.account.step17.domain.Account;
import fr.gboissinot.al.account.step17.domain.AccountException;
import fr.gboissinot.al.account.step17.domain.AccountId;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class InMemoryAccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort, CreateAccountPort {

    private final Map<AccountId, Account> registry = new HashMap<>();

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void save(Account account) {
        registry.put(account.id(), account);
    }

    @Override
    public Account load(AccountId accountId) {
        return registry.computeIfAbsent(accountId,
                key -> {
                    throw AccountException.notFoundAccountId(accountId);
                });
    }

    @Override
    public void update(Account account) {
        registry.put(account.id(), account);
    }
}