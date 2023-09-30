package fr.gboissinot.al.account.step13.application.port.out;

import fr.gboissinot.al.account.step13.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
