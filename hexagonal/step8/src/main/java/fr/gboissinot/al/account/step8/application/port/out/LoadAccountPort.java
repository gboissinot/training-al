package fr.gboissinot.al.account.step8.application.port.out;

import fr.gboissinot.al.account.step8.domain.Account;
import fr.gboissinot.al.account.step8.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
