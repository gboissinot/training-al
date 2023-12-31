package fr.gboissinot.al.account.step3.adapter.in;

import fr.gboissinot.al.account.step3.application.services.AccountService;
import fr.gboissinot.al.account.step3.domain.AccountId;
import fr.gboissinot.al.account.step3.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void transfer(AccountId source, AccountId target, Money money) {
        accountService.sendMoney(source, target, money);
    }
}
