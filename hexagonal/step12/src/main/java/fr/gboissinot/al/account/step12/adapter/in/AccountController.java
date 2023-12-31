package fr.gboissinot.al.account.step12.adapter.in;

import fr.gboissinot.al.account.step12.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step12.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step12.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step12.domain.AccountId;
import fr.gboissinot.al.account.step12.domain.Money;
import fr.gboissinot.al.kernel.CommandBus;
import fr.gboissinot.al.kernel.QueryBus;

public final class AccountController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public AccountController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public AccountId create(Money initialAmount) {
        return (AccountId) commandBus.post(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        commandBus.post(new SendMoneyCommand(source, target, amount));
    }

    public Money getBalance(AccountId accountId) {
        return (Money) queryBus.post(new AccountBalanceQuery(accountId));
    }
}
