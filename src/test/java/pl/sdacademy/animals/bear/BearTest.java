package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void BlackBearShouldBeAliveRightAfterCreation() {
        DateTime currentTime = DateTime.now();
        Bear bear = new BlackBear(5, currentTime);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BrownBearShouldBeAliveRightAfterCreation() {
        DateTime currentTime = DateTime.now();
        Bear bear = new BrownBear(5, currentTime);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void PolarBearShouldBeAliveRightAfterCreation() {
        DateTime currentTime = DateTime.now();
        Bear bear = new PolarBear(5, currentTime);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BlackBearShouldBeAliveIfHeEatWithin10Days(){
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new BlackBear(3, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BrownBearShouldBeAliveIfHeEatWithin10Days(){
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new BrownBear(2, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void PolarBearShouldBeAliveIfHeEatWithin10Days(){
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new PolarBear(5, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BlackBearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new BlackBear(5, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void BrownBearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new BrownBear(1, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void PolarBearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new PolarBear(1, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void BlackBearShouldBeJesus(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BlackBear(5, currentTime);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void ifBlackBearEatHeWouldGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BlackBear(3, currentTime);
        bear.eat(3);

        int newWeight = bear.getWeight();

        assertEquals(6, newWeight);
    }

    @Test
    void ifBrownBearEatHeWouldGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BrownBear(1, currentTime);
        bear.eat(1);

        int newWeight = bear.getWeight();

        assertEquals(2, newWeight);
    }

    @Test
    void ifPolarBearEatHeWouldGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new PolarBear(10, currentTime);
        bear.eat(5);

        int newWeight = bear.getWeight();

        assertEquals(15, newWeight);
    }



}