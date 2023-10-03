package fr.gboissinot.al.tps.oop.tp22;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    public void the_player_starts_at_a_position_anc_can_move_left() {
        var initialPosition = new Position(10, 20);
        var player = new Player(initialPosition);
        player.moveLeft(2);
        player.moveLeft(3);
        Assertions.assertEquals(new Position(5, 20)
                , player.playerReport().currentPosition());
    }


}
