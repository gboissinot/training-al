package fr.gboissinot.al.account.step16.application.port.out;

import fr.gboissinot.al.account.step16.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
