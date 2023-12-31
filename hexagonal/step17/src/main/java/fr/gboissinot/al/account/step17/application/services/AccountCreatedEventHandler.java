package fr.gboissinot.al.account.step17.application.services;

import fr.gboissinot.al.account.step17.application.events.AccountCreatedEvent;
import fr.gboissinot.al.account.step17.application.port.out.Notifications;
import fr.gboissinot.al.kernel.EventHandler;

public final class AccountCreatedEventHandler implements EventHandler<AccountCreatedEvent> {

    private final Notifications notifications;

    public AccountCreatedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(AccountCreatedEvent event) {
        notifications.notify(String.format("Notification of the account creation %s with %s.", event.getAccountId(), event.getAmount().value()));
    }
}
