package fr.gboissinot.al.account.step17.application.services;

import fr.gboissinot.al.account.step17.application.events.TransferAcceptedEvent;
import fr.gboissinot.al.account.step17.application.port.out.Notifications;
import fr.gboissinot.al.kernel.EventHandler;

public final class TransferAcceptedEventHandler implements EventHandler<TransferAcceptedEvent> {

    private final Notifications notifications;

    public TransferAcceptedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(TransferAcceptedEvent event) {
        notifications.notify(String.format("Notification of the transfer acceptation of %f between %s and %s.",
                event.getAmount().value(),
                event.getSourceAccountId().value(),
                event.getTargetAccountId().value()));
    }
}
