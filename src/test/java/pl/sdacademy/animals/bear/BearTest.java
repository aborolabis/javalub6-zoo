package pl.sdacademy.animals.bear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveRightAfterCreation() {
        Bear bear = new BlackBear(5);
        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void bearShouldBeAliveIfHeEatWithin10Days(){
        Bear bear = new BlackBear(5);
        bear.eat();

        boolean alive = bear.isAlive();

        assertTrue(alive);
    }

    @Test
    void bearShouldBeDeadIfHeDidntEatFor10Days(){
        Bear bear = new BlackBear(5);
        bear.eat();


    }

/*    @Test
    void eat() {
    }

    @Test
    void getWeight() {
    }*/
}