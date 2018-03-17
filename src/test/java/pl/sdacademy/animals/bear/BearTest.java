package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import pl.sdacademy.animals.Time.BearClock;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void BlackBearShouldBeAliveRightAfterCreation() {
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
        TestClock clock = new TestClock();
        Bear bear = new BlackBear(5, clock);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void BrownBearShouldBeDeadIfHeDidntEatFor10Days(){
        TestClock clock = new TestClock();
        Bear bear = new BrownBear(1, clock);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void PolarBearShouldBeDeadIfHeDidntEatFor10Days(){
        TestClock clock = new TestClock();
        Bear bear = new PolarBear(1, clock);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void ifBlackBearEatHeWouldGetOnWeight(){
        Bear bear = new BlackBear(3);
        bear.eat(3);

        double newWeight = bear.getWeight();

        assertEquals(6, newWeight);

    }

    @Test
    void ifBrownBearEatHeWouldGetOnWeight(){
        Bear bear = new BrownBear(1);
        bear.eat(1);

        double newWeight = bear.getWeight();

        assertEquals(2, newWeight);
    }

    @Test
    void ifPolarBearEatHeWouldGetOnWeight(){
        Bear bear = new PolarBear(10);
        bear.eat(5);

        double newWeight = bear.getWeight();

        assertEquals(15, newWeight);
    }

    @Test
    void whenBlackBearDrinksHeGetOnWeight(){
        Bear bear = new BlackBear(12);
        bear.drink(0.7);

        double newWeight = bear.getWeight();

        assertEquals(12.525, newWeight);
    }

    @Test
    void whenBrownBearDrinksHeGetOnWeight(){
        Bear bear = new BrownBear(20);
        bear.drink(12);

        double newWeight = bear.getWeight();

        assertEquals(29, newWeight);
    }

    @Test
    void whenPolarBearDrinksHeGetOnWeight(){
        Bear bear = new PolarBear(65);
        bear.drink(16);

        double newWeight = bear.getWeight();

        assertEquals(77, newWeight);
    }

    @Test
    void whenBlackBearPoopHisWeightGoingDownBy5Per(){
        Bear bear = new BlackBear(20);
        bear.poop();

        double newWeight = bear.getWeight();

        assertEquals(19, newWeight);
    }

    @Test
    void whenBrownBearPoopHisWeightGoingDownBy5Per(){
        Bear bear = new BrownBear(15);
        bear.poop();

        double newWeight = bear.getWeight();

        assertEquals(14.25, newWeight);
    }

    @Test
    void whenPolarBearPoopHisWeightGoingDownBy5Per(){
        Bear bear = new PolarBear(7);
        bear.poop();

        double newWeight = bear.getWeight();

        assertEquals(6.65, newWeight);
    }

    class TestClock extends BearClock {
        int counter = 0;

        @Override
        public DateTime getCurrentTime() {
            counter++;
            if (counter > 2)
                return DateTime.now().plusDays(20);
            else
                return DateTime.now();
        }
    }
}