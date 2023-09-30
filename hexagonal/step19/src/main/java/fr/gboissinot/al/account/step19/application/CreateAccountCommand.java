package fr.gboissinot.al.account.step19.application;

import fr.gboissinot.al.kernel.Command;

import javax.validation.constraints.NotNull;

public final class CreateAccountCommand implements Command {

    @NotNull
    public final double initialMoney;

    public CreateAccountCommand(double initialMoney) {
        this.initialMoney = initialMoney;
    }
}
