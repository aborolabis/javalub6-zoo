package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveRightAfterCreation() {
        DateTime currentTime = DateTime.now();
        Bear bear = new BlackBear(5, currentTime);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void bearShouldBeAliveIfHeEatWithin10Days(){
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new BlackBear(5, currentTime);
        bear.eat();

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void bearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new BlackBear(5, currentTime);
        bear.eat();

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

}