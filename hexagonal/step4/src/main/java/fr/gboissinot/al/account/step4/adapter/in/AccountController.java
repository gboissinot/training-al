package fr.gboissinot.al.account.step4.adapter.in;

import fr.gboissinot.al.account.step4.application.services.AccountService;
import fr.gboissinot.al.account.step4.domain.AccountId;
import fr.gboissinot.al.account.step4.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountId create(Money initialAmount) {
        return accountService.createAccount(initialAmount);
    }

    public void transfer(AccountId source, AccountId target, Money money) {
        accountService.sendMoney(source, target, money);
    }
}
