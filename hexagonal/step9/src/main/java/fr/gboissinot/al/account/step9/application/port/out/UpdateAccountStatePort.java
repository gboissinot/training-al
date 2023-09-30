package fr.gboissinot.al.account.step9.application.port.out;

import fr.gboissinot.al.account.step9.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
