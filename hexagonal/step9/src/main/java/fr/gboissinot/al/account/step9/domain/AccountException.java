package fr.gboissinot.al.account.step9.domain;

public final class AccountException extends RuntimeException {
    private AccountException(String message) {
        super(message);
    }

    public static AccountException notFoundAccountId(AccountId accountId) {
        return new AccountException(String.format("%s not found.", accountId.value()));
    }
}
