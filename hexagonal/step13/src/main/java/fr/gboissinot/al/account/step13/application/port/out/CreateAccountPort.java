package fr.gboissinot.al.account.step13.application.port.out;

import fr.gboissinot.al.account.step13.domain.Account;
import fr.gboissinot.al.account.step13.domain.AccountId;

public interface CreateAccountPort {
    AccountId nextId();

    void save(Account account);
}
