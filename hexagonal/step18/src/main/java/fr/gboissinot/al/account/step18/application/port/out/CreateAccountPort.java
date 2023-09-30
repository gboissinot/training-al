package fr.gboissinot.al.account.step18.application.port.out;

import fr.gboissinot.al.account.step18.domain.Account;
import fr.gboissinot.al.account.step18.domain.AccountId;

public interface CreateAccountPort {
    AccountId nextId();

    void save(Account account);
}
