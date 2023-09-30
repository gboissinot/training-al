package fr.gboissinot.al.account.step5.adapter.in;

import fr.gboissinot.al.account.step5.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step5.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step5.application.services.AccountService;
import fr.gboissinot.al.account.step5.domain.AccountId;
import fr.gboissinot.al.account.step5.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountId create(Money initialAmount) {
        return accountService.createAccount(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        accountService.sendMoney(new SendMoneyCommand(source, target, amount));
    }
}
