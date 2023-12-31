package fr.gboissinot.al.account.step13.adapter.in;

import fr.gboissinot.al.account.step13.application.port.in.AccountBalanceQuery;
import fr.gboissinot.al.account.step13.application.port.in.CreateAccountCommand;
import fr.gboissinot.al.account.step13.application.port.in.SendMoneyCommand;
import fr.gboissinot.al.account.step13.domain.AccountId;
import fr.gboissinot.al.account.step13.domain.Money;
import fr.gboissinot.al.kernel.Command;
import fr.gboissinot.al.kernel.CommandBus;
import fr.gboissinot.al.kernel.Query;
import fr.gboissinot.al.kernel.QueryBus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountWebController {

    private final CommandBus<Command> commandBus;
    private final QueryBus<Query> queryBus;

    public AccountWebController(CommandBus<Command> commandBus, QueryBus<Query> queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAccountResponse create(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        var accountId = (AccountId) commandBus.post(new CreateAccountCommand(Money.of(createAccountRequest.amount)));
        return new CreateAccountResponse(accountId.value());
    }

    @PostMapping(value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transfer(@RequestBody @Valid TransferAccountRequest transferAccountRequest) {
        commandBus.post(new SendMoneyCommand(
                AccountId.of(UUID.fromString(transferAccountRequest.sourceAccountId)),
                AccountId.of(UUID.fromString(transferAccountRequest.targetAccountId)),
                Money.of(transferAccountRequest.amount)
        ));
    }

    @GetMapping
    public GetBalanceResponse getBalance(@RequestParam String accountId) {
        var balance = (Money) queryBus.post(new AccountBalanceQuery(AccountId.of(UUID.fromString(accountId))));
        return new GetBalanceResponse(balance.value());
    }
}
