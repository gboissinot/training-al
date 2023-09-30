package fr.gboissinot.al.account.step6.application.port.in;

import fr.gboissinot.al.account.step6.domain.Money;

import java.util.Objects;

public final class CreateAccountCommand {

    public final Money initialMoney;

    public CreateAccountCommand(Money initialMoney) {
        this.initialMoney = Objects.requireNonNull(initialMoney);
    }
}
