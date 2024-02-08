package fr.gboissinot.al.account.step19.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.gboissinot.al.account.step19.domain.model.Account;
import fr.gboissinot.al.account.step19.domain.model.AccountException;
import fr.gboissinot.al.account.step19.domain.model.AccountId;
import fr.gboissinot.al.account.step19.domain.model.Accounts;
import fr.gboissinot.al.kernel.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class JPAAccounts implements Accounts {

    private final AccountEntityRepository accountEntityRepository;

    public JPAAccounts(AccountEntityRepository accountEntityRepository) {
        this.accountEntityRepository = accountEntityRepository;
    }

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void add(Account account) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        var accountEntity = new AccountEntity(account.id().value(),
                account.getRecordedEvents().stream().map(event ->
                        new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));
        accountEntityRepository.save(accountEntity);
    }

    @Override
    public Account findById(AccountId accountId) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        final Optional<AccountEntity> optionalAccountEntity = accountEntityRepository.findById(accountId.value());
        if (optionalAccountEntity.isPresent()) {
            var accountEntity = optionalAccountEntity.get();

            final List<EventEntity> accountEntityRecordedEvents = accountEntity.getRecordedEvents();
            final List<Event> result = new ArrayList<>();
            for (EventEntity eventEntity : accountEntityRecordedEvents) {
                try {
                    final Event event = (Event) gson.fromJson(eventEntity.getData(), Class.forName(eventEntity.getClassname()));
                    result.add(event);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            return new Account(AccountId.of(UUID.fromString(accountEntity.getId())), result);
        }
        throw AccountException.notFoundAccountId(accountId);
    }
}