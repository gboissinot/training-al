package fr.gboissinot.al.account.step14.application.port.out;

import fr.gboissinot.al.account.step14.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
