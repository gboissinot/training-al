package fr.gboissinot.al.account.step11.adapter.in;

import fr.gboissinot.al.account.step11.application.port.in.*;
import fr.gboissinot.al.account.step11.domain.AccountId;
import fr.gboissinot.al.account.step11.domain.Money;

public final class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;
    private final GetAccountBalanceUseCase getAccountBalanceUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, SendMoneyUseCase sendMoneyUseCase, GetAccountBalanceUseCase getAccountBalanceUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.sendMoneyUseCase = sendMoneyUseCase;
        this.getAccountBalanceUseCase = getAccountBalanceUseCase;
    }

    public AccountId create(Money initialAmount) {
        return createAccountUseCase.handle(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        sendMoneyUseCase.handle(new SendMoneyCommand(source, target, amount));
    }

    public Money getBalance(AccountId accountId) {
        return getAccountBalanceUseCase.handle(new AccountBalanceQuery(accountId));
    }
}
