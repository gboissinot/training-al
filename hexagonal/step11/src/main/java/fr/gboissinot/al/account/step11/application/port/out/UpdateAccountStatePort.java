package fr.gboissinot.al.account.step11.application.port.out;

import fr.gboissinot.al.account.step11.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
