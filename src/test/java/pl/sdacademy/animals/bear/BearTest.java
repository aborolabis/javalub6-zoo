package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import pl.sdacademy.animals.Time.BearClock;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void BlackBearShouldBeAliveRightAfterCreation() {
        BearClock clock = new BearClock();
        Bear bear = new BlackBear(5);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BrownBearShouldBeAliveRightAfterCreation() {
        Bear bear = new BrownBear(5);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void PolarBearShouldBeAliveRightAfterCreation() {
        Bear bear = new PolarBear(5);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BlackBearShouldBeAliveIfHeEatWithin10Days(){
        Bear bear = new BlackBear(3);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BrownBearShouldBeAliveIfHeEatWithin10Days(){
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new BrownBear(2);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void PolarBearShouldBeAliveIfHeEatWithin10Days(){
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new PolarBear(5);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BlackBearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new BlackBear(5);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void BrownBearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new BrownBear(1);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void PolarBearShouldBeDeadIfHeDidntEatFor10Days(){
        DateTime currentTime = DateTime.now().plusDays(20);
        Bear bear = new PolarBear(1);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void ifBlackBearEatHeWouldGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BlackBear(3);
        bear.eat(3);

        double newWeight = bear.getWeight();

        assertEquals(6, newWeight);

    }

    @Test
    void ifBrownBearEatHeWouldGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BrownBear(1);
        bear.eat(1);

        double newWeight = bear.getWeight();

        assertEquals(2, newWeight);
    }

    @Test
    void ifPolarBearEatHeWouldGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new PolarBear(10);
        bear.eat(5);

        double newWeight = bear.getWeight();

        assertEquals(15, newWeight);
    }

    @Test
    void whenBlackBearDrinksHeGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BlackBear(12);
        bear.drink(0.7);

        double newWeight = bear.getWeight();

        assertEquals(12.525, newWeight);
    }

    @Test
    void whenBrownBearDrinksHeGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new BrownBear(20);
        bear.drink(12);

        double newWeight = bear.getWeight();

        assertEquals(29, newWeight);
    }

    @Test
    void whenPolarBearDrinksHeGetOnWeight(){
        DateTime currentTime = DateTime.now();
        Bear bear = new PolarBear(65);
        bear.drink(16);

        double newWeight = bear.getWeight();

        assertEquals(77, newWeight);
    }



}