package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import pl.sdacademy.animals.Time.BearClock;

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
    void BlackBearShouldBeAliveIfHeEatWithin10Days() throws BearHibernatingException {
        Bear bear = new BlackBear(3);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BrownBearShouldBeAliveIfHeEatWithin10Days() throws BearHibernatingException {
        Bear bear = new BrownBear(2);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void PolarBearShouldBeAliveIfHeEatWithin10Days() throws BearHibernatingException {
        DateTime currentTime = DateTime.now().plusDays(8);
        Bear bear = new PolarBear(5);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void BlackBearShouldBeDeadIfHeDidntEatFor10Days() throws BearHibernatingException {
        TestClock clock = new TestClock();
        Bear bear = new BlackBear(5, clock);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void BrownBearShouldBeDeadIfHeDidntEatFor10Days() throws BearHibernatingException {
        TestClock clock = new TestClock();
        Bear bear = new BrownBear(1, clock);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void PolarBearShouldBeDeadIfHeDidntEatFor10Days() throws BearHibernatingException {
        TestClock clock = new TestClock();
        Bear bear = new PolarBear(1, clock);
        bear.eat(0);

        boolean alive = bear.isAlive();

        assertTrue(!alive);
    }

    @Test
    void ifBlackBearEatHeWouldGetOnWeight() throws BearHibernatingException {
        Bear bear = new BlackBear(3);
        bear.eat(3);

        double newWeight = bear.getWeight();

        assertEquals(6, newWeight);

    }

    @Test
    void ifBrownBearEatHeWouldGetOnWeight() throws BearHibernatingException {
        Bear bear = new BrownBear(1);
        bear.eat(1);

        double newWeight = bear.getWeight();

        assertEquals(2, newWeight);
    }

    @Test
    void ifPolarBearEatHeWouldGetOnWeight() throws BearHibernatingException {
        Bear bear = new PolarBear(10);
        bear.eat(5);

        double newWeight = bear.getWeight();

        assertEquals(15, newWeight);
    }

    @Test
    void whenBlackBearDrinksHeGetOnWeight() throws BearHibernatingException {
        Bear bear = new BlackBear(12);
        bear.drink(0.7);

        double newWeight = bear.getWeight();

        assertEquals(12.525, newWeight);
    }

    @Test
    void whenBrownBearDrinksHeGetOnWeight() throws BearHibernatingException {
        Bear bear = new BrownBear(20);
        bear.drink(12);

        double newWeight = bear.getWeight();

        assertEquals(29, newWeight);
    }

    @Test
    void whenPolarBearDrinksHeGetOnWeight() throws BearHibernatingException {
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

    @Test
    void blackBearShouldHibernateIfItsBetween20OfNov15OfMarch(){
        TestClockBlackBear clock = new TestClockBlackBear();
        Bear bear = new BlackBear(10, clock);

        boolean isHibernate = bear.isHibernating();

        assertTrue(isHibernate);
    }

    @Test
    void blackBearShouldntHibernateIfItsBetween15OfMarch20OfNov(){
        BearClock clock = new BearClock();
        Bear bear = new BlackBear(10, clock);

        boolean isHibernate = bear.isHibernating();

        assertTrue(!isHibernate);
    }

    @Test
    void polarBearShouldHibernateIfItsBetween5OfMay10OfOct(){
        BearClock clock = new TestClockPolarBear();
        Bear bear = new PolarBear(10, clock);

        boolean isHibernate = bear.isHibernating();

        assertTrue(isHibernate);
    }

    @Test
    void polarBearShouldntHibernateIfItsBetween10OfOct5OfMay(){
        BearClock clock = new BearClock();
        Bear bear = new PolarBear(10, clock);

        boolean isHibernate = bear.isHibernating();

        assertTrue(!isHibernate);
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

    class TestClockBlackBear extends BearClock{
        @Override
        public DateTime getCurrentTime() {
            return DateTime.now().plusMonths(9);
        }
    }

    class TestClockPolarBear extends BearClock{
        @Override
        public DateTime getCurrentTime() {
            return DateTime.now().plusMonths(4);
        }
    }
}