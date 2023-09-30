package fr.gboissinot.al.account.step19.application.events;

import fr.gboissinot.al.account.step19.application.Notifications;
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
