package fr.gboissinot.al.account.step18.application.services;

import fr.gboissinot.al.account.step18.application.events.AccountCreatedApplicationEvent;
import fr.gboissinot.al.account.step18.application.port.out.Notifications;
import fr.gboissinot.al.kernel.EventHandler;

public final class AccountCreatedEventHandler implements EventHandler<AccountCreatedApplicationEvent> {

    private final Notifications notifications;

    public AccountCreatedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(AccountCreatedApplicationEvent event) {
        notifications.notify(String.format("Notification of the account creation %s with %s.", event.getAccountId(), event.getAmount().value()));
    }
}
