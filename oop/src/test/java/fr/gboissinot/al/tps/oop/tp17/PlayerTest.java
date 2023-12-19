package fr.gboissinot.al.tps.oop.tp17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void the_player_starts_at_a_position_anc_can_move_left() {
        var initialPosition = new Position(10, 20);
        var player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(new Position(6, 20), player.currentPosition());
    }

    @Test
    void the_player_starts_at_a_position_anc_can_move_left2() {
        var initialPosition = new Position(10, 20);
        var player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(new Player(new Position(6, 20)), player);
    }
}
