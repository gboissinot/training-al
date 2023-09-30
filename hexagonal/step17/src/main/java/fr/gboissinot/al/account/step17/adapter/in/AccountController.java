package fr.gboissinot.al.account.step17.adapter.in;

import fr.gboissinot.al.account.step17.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step17.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step17.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.kernel.CommandBus;
import fr.gboissinot.al.kernel.QueryBus;

public final class AccountController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public AccountController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public String create(double initialAmount) {
        return (String) commandBus.post(new CreateAccountCommand(initialAmount));
    }

    public void transfer(String sourceAccountId, String targetAccountId, double amount) {
        commandBus.post(new SendMoneyCommand(sourceAccountId, targetAccountId, amount));
    }

    public double getBalance(String accountId) {
        return (double) queryBus.post(new AccountBalanceQuery(accountId));
    }
}
