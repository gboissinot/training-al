package fr.gboissinot.al.tps.oop.tp23;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EventDispatcherTest {

    @Mock
    private EventDispatcher eventDispatcher;

    @Test
    void it_dispatch_a_user_password_changed_event() {
        var userId1 = new UserId("1");
        var user = new User(userId1, "Greg", "123");
        var userRepository = new InMemoryUserRepository(new HashMap<>());
        userRepository.save(user);

        var userService = new UserService(userRepository, eventDispatcher);
        userService.changePassword(userId1, "new password");
        verify(eventDispatcher, times(1)).dispatch(new PasswordChangedEvent());
    }
}


