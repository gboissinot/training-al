package fr.gboissinot.al.account.step16.adapter.in;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TransferAccountRequest {
    @NotNull
    public String sourceAccountId;
    @NotNull
    public String targetAccountId;
    @Positive
    public double amount;
}
