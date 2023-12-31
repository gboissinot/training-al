package fr.gboissinot.al.tps.oop.tp23;

import fr.gboissinot.al.tps.oop.tp23.kernel.EventDispatcher;

final class UserService {

    private final UserRepository userRepository;
    private final EventDispatcher eventDispatcher;

    public UserService(UserRepository userRepository, EventDispatcher eventDispatcher) {
        this.userRepository = userRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public void changePassword(UserId userId, String newPassword) {
        var user = userRepository.getById(userId);
        user.changePassword(newPassword);
        this.userRepository.save(user);
        this.eventDispatcher.dispatch(new PasswordChangedEvent());
    }
}
