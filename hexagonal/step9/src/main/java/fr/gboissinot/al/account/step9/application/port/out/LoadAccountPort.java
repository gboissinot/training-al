package fr.gboissinot.al.account.step9.application.port.out;

import fr.gboissinot.al.account.step9.domain.Account;
import fr.gboissinot.al.account.step9.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
