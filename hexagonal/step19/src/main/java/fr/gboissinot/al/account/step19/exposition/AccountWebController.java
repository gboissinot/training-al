package fr.gboissinot.al.account.step19.exposition;

import fr.gboissinot.al.account.step19.domain.services.AccountBalanceQuery;
import fr.gboissinot.al.account.step19.domain.services.CreateAccountCommand;
import fr.gboissinot.al.account.step19.domain.services.SendMoneyCommand;
import fr.gboissinot.al.kernel.CommandBus;
import fr.gboissinot.al.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
@SuppressWarnings("all")
public class AccountWebController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private AccountWebController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAccountResponse create(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        var accountId = (String) commandBus.post(new CreateAccountCommand(createAccountRequest.amount));
        return new CreateAccountResponse(accountId);
    }

    @PostMapping(value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transfer(@RequestBody @Valid TransferAccountRequest transferAccountRequest) {
        commandBus.post(new SendMoneyCommand(
                transferAccountRequest.sourceAccountId,
                transferAccountRequest.targetAccountId,
                transferAccountRequest.amount
        ));
    }

    @GetMapping
    public GetBalanceResponse getBalance(@RequestParam String accountId) {
        var balance = (Double) queryBus.post(new AccountBalanceQuery(accountId));
        return new GetBalanceResponse(balance);
    }
}
