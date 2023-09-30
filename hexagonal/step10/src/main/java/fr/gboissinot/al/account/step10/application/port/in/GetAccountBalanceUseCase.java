package fr.gboissinot.al.account.step10.application.port.in;

import fr.gboissinot.al.account.step10.domain.Money;

public interface GetAccountBalanceUseCase {
    Money balance(AccountBalanceQuery balanceQuery);
}
