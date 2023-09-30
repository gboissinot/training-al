package fr.gboissinot.al.account.step7.domain;

public record AccountConfiguration(long transferThreshold) {

    public long getTransferThreshold() {
        return transferThreshold;
    }
}
