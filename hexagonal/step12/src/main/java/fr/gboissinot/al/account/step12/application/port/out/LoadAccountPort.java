package fr.gboissinot.al.account.step12.application.port.out;

import fr.gboissinot.al.account.step12.domain.Account;
import fr.gboissinot.al.account.step12.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
