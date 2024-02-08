package fr.gboissinot.al.account.step19.domain.model;

public interface Accounts {

    AccountId nextId();

    Account findById(AccountId accountId);

    void add(Account account);
}
