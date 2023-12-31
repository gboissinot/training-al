package fr.gboissinot.al.tps.oop.tp10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class YearValueObjectTest {

    @Test
    void test() {
        var year = new Year(2022);
        year.next();
        Assertions.assertEquals(new Year(2022), year);

        year = year.next();
        Assertions.assertEquals(new Year(2023), year);
    }
}
