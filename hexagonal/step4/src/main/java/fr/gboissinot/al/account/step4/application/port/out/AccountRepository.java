package fr.gboissinot.al.account.step4.application.port.out;

import fr.gboissinot.al.account.step4.domain.Account;
import fr.gboissinot.al.account.step4.domain.AccountId;

public interface AccountRepository {

    AccountId nextId();

    Account findById(AccountId accountId);

    void save(Account account);
}
