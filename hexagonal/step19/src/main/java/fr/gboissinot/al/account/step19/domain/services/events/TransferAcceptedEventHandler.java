package fr.gboissinot.al.account.step19.domain.services.events;

import fr.gboissinot.al.account.step19.domain.services.Notifications;
import fr.gboissinot.al.kernel.EventHandler;

public final class TransferAcceptedEventHandler implements EventHandler<TransferAcceptedApplicationEvent> {

    private final Notifications notifications;

    public TransferAcceptedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(TransferAcceptedApplicationEvent event) {
        notifications.notify(String.format("Notification of the transfer acceptation of %f between %s and %s.",
                event.getAmount().value(),
                event.getSourceAccountId().value(),
                event.getTargetAccountId().value()));
    }
}
