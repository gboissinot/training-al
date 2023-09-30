package fr.gboissinot.al.account.step14.application.port.out;

import fr.gboissinot.al.account.step14.domain.Account;
import fr.gboissinot.al.account.step14.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
