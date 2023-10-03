package fr.gboissinot.al.tps.oop.tpDemo1;

import org.junit.jupiter.api.Test;

class MyServiceTest {


    @Test
    public void test_dummy_logger() {
        var myService = new MyService(new DummyLogger());
        myService.myMethod();
    }
}
