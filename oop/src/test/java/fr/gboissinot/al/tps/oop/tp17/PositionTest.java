package fr.gboissinot.al.tps.oop.tp17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class PositionTest {

    @Test
    void it_can_move_to_the_left() {
        var position = new Position(10, 20);
        position = position.toTheLeft(4);
        Assertions.assertEquals(new Position(6, 20), position);
    }
}
