package fr.gboissinot.al.account.step15.application.port.out;

import fr.gboissinot.al.account.step15.domain.Account;
import fr.gboissinot.al.account.step15.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
