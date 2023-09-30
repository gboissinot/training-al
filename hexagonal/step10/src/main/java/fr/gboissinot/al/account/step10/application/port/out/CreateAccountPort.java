package fr.gboissinot.al.account.step10.application.port.out;

import fr.gboissinot.al.account.step10.domain.Account;
import fr.gboissinot.al.account.step10.domain.AccountId;

public interface CreateAccountPort {
    AccountId nextId();

    void save(Account account);
}
