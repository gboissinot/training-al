package fr.gboissinot.al.tps.oop.live.tpCorrectionRegistry2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class UserServiceTest {

    @Test
    void test() {
        var userRegistry = new InMemoryUserRegistry();
        var userService = new UserService(userRegistry);
        var userId = userService.register("GREGORY", "BOISSINOT");


        var registeredUser = userRegistry.getById(userId);
        Assertions.assertEquals(User.of(userId,"GREGORY", "BOISSINOT"),registeredUser);
    }
}
