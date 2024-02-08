package fr.gboissinot.al.account.step19.infrastructure;

import fr.gboissinot.al.account.step19.domain.services.Notifications;

public final class LogNotifications implements Notifications {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
