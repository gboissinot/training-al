package fr.gboissinot.al.account.step16.application.port.out;

import fr.gboissinot.al.account.step16.domain.Account;
import fr.gboissinot.al.account.step16.domain.AccountId;

public interface CreateAccountPort {
    AccountId nextId();

    void save(Account account);
}
