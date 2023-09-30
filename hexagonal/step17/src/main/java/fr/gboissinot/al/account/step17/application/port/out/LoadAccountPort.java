package fr.gboissinot.al.account.step17.application.port.out;

import fr.gboissinot.al.account.step17.domain.Account;
import fr.gboissinot.al.account.step17.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
