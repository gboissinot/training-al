package fr.gboissinot.al.account.step8.application.port.out;

import fr.gboissinot.al.account.step8.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
