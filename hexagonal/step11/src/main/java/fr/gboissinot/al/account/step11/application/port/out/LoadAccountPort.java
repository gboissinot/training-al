package fr.gboissinot.al.account.step11.application.port.out;

import fr.gboissinot.al.account.step11.domain.Account;
import fr.gboissinot.al.account.step11.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
