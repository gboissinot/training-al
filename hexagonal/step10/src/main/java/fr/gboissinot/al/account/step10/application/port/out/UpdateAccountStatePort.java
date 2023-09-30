package fr.gboissinot.al.account.step10.application.port.out;

import fr.gboissinot.al.account.step10.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
