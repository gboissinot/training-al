package fr.gboissinot.al.tps.oop.tp23;

import fr.gboissinot.al.tps.oop.tp23.kernel.Listener;

final class MailListener implements Listener<PasswordChangedEvent> {
    @Override
    public void listenTo(PasswordChangedEvent passwordChangedEvent) {
        System.out.println("[Mail Notification] - Password has changed.");
    }
}
