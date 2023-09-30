package fr.gboissinot.al.account.step12.application.port.in;

import fr.gboissinot.al.account.step12.domain.Money;
import fr.gboissinot.al.kernel.Command;

import javax.validation.constraints.NotNull;

public final class CreateAccountCommand implements Command {

    @NotNull
    public final Money initialMoney;

    public CreateAccountCommand(Money initialMoney) {
        this.initialMoney = initialMoney;
    }
}
