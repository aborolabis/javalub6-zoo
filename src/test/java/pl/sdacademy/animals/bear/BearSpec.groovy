package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import pl.sdacademy.animals.Time.BearClock
import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        def clock = Mock(BearClock)
        clock.getCurrentTime() >> DateTime.now().plusDays(11)
        Bear bear = testBear

        when:
        boolean result = bear.isAlive()

        then:
        result

        where:
        testBear << [new BlackBear(1),
                     new BrownBear(2),
                     new PolarBear(3)]
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        BearClock bearClock = clock
        def bear = testBear
        bear.eat(0)

        when:
        boolean result = bear.isAlive()

        then:
        result

        where:
        clock << [new BearClock(), new BearClock(), new BearClock()]
        testBear << [new BlackBear(3, clock),
                     new BrownBear(5, clock),
                     new PolarBear(1, clock)]

    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {
        given:
        TestClock testClock = clock
        Bear bear = testBear
        bear.eat(0)

        when:
        boolean result = bear.isAlive()

        then:
        !result

        where:
        clock << [new TestClock(), new TestClock(), new TestClock()]
        testBear << [new BlackBear(3, clock),
                     new BrownBear(5, clock),
                     new PolarBear(1, clock)]
    }

    def "Bear should get on weight if he eats"() {
        given:
        BearClock bearClock = clock
        Bear bear = testBear
        bear.eat(5)

        when:
        double newWeight = bear.getWeight()

        then:
        newWeight == expected

        where:
        clock << [new BearClock(), new BearClock(), new BearClock()]
        testBear << [new BlackBear(10, clock),
                     new BrownBear(5, clock),
                     new PolarBear(20, clock)]
        expected << [15, 10, 25]
    }

    def "Bear should get on weight by 3/4 of waterWeight, which he was drinking"() {
        given:
        Bear bear = testBear
        bear.drink(12)

        when:
        double newWeight = bear.getWeight()

        then:
        newWeight == expected

        where:
        testBear << [new BlackBear(20), new BrownBear(10), new PolarBear(102)]
        expected << [29, 19, 111]
    }

    def "when bear poop his weight goes down by 5 %"() {
        given:
        BearClock bearClock = clock
        Bear bear = testBear
        bear.poop()

        when:
        double newWeight = bear.getWeight()

        then:
        newWeight == expected

        where:
        clock << [new BearClock(), new BearClock(), new BearClock()]
        testBear << [new BlackBear(20, clock), new BrownBear(15, clock), new PolarBear(7, clock)]
        expected << [19, 14.25, 6.65]
    }

    def "Black Bears shouldnt hibernate from 15 of March to 20 of November"() {
        given:
        BearClock clock = new BearClock()
        Bear bear = new BlackBear(10, clock)

        when:
        boolean isHibernate = bear.isHibernating()

        then:
        !isHibernate
    }

    def "Black Bears should hibernate from 20 of November to 15 of March"() {
        given:
        BearClock clock = new TestClockBlackBears()
        Bear bear = new BlackBear(10, clock)

        when:
        boolean isHibernate = bear.isHibernating()

        then:
        isHibernate
    }

    def "Polar Bears should hibernate from 5 of May to 10 of October"() {
        given:
        BearClock clock = new TestClockPolarBears()
        Bear bear = new PolarBear(10, clock)

        when:
        boolean isHibernate = bear.isHibernating()

        then:
        isHibernate
    }

    def "Polar Bears shouldnt hibernate from 10 of October to 5 of May"(){
        given:
        BearClock clock = new BearClock()
        Bear bear = new PolarBear(10, clock)

        when:
        boolean isHibernate = bear.isHibernating()

        then:
        !isHibernate
    }

    def "Black Bear should throw an Exception if we want to feed him while hibernating"(){
        given:
        BearClock clock = new TestClockBlackBears()
        Bear bear = new BlackBear(10, clock)

        when:
        bear.eat(10)

        then:
        thrown BearHibernatingException
    }

    def "Black Bear should throw an Exception if we want to let him drink while hibernating"(){
        given:
        BearClock clock = new TestClockBlackBears()
        Bear bear = new BlackBear(10, clock)

        when:
        bear.drink(10)

        then:
        thrown BearHibernatingException
    }

    def "Polar Bear should throw an Exception if we want to feed him while hibernating"(){
        given:
        BearClock clock = new TestClockPolarBears()
        Bear bear = new PolarBear(10, clock)

        when:
        bear.eat(10)

        then:
        thrown BearHibernatingException
    }

    def "Polar Bear should throw an Exception if we want to let him drink while hibernating"(){
        given:
        BearClock clock = new TestClockPolarBears()
        Bear bear = new PolarBear(10, clock)

        when:
        bear.drink(10)

        then:
        thrown BearHibernatingException
    }


    class TestClock extends BearClock {
        int counter = 0;

        @Override
        DateTime getCurrentTime() {
            counter++
            if (counter > 0)
                return DateTime.now().plusDays(20)
            else
                return DateTime.now()
        }
    }

    class TestClockBlackBears extends BearClock {
        @Override
        DateTime getCurrentTime() {
            return DateTime.now().plusMonths(9)
        }
    }

    class TestClockPolarBears extends BearClock {
        @Override
        DateTime getCurrentTime() {
            return DateTime.now().plusMonths(4)
        }
    }
}
