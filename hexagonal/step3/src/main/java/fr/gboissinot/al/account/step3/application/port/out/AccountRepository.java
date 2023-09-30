package fr.gboissinot.al.account.step3.application.port.out;

import fr.gboissinot.al.account.step3.domain.Account;
import fr.gboissinot.al.account.step3.domain.AccountId;

public interface AccountRepository {
    Account findById(AccountId accountId);

    void save(Account account);
}
