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
        boolean  result = bear.isAlive()

        then:
        result

        where:
        testBear << [new BlackBear(1),
                     new BrownBear(2),
                     new PolarBear(3)]
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        Bear bear = testBear
        bear.eat(0)

        when:
        boolean result = bear.isAlive()

        then:
        result

        where:
        testBear << [new BlackBear(3, DateTime.now()),
                     new BrownBear(5, DateTime.now()),
                     new PolarBear(1, DateTime.now())]
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {
        given:
        Bear bear = testBear
        bear.eat(0)

        when:
        boolean result = bear.isAlive()

        then:
        !result

        where:
        testBear << [new BlackBear(3, DateTime.now().plusDays(20)),
                     new BrownBear(5, DateTime.now().plusDays(11)),
                     new PolarBear(1, DateTime.now().plusDays(50))]
    }

    def "Bear should get on weight if he eats"(){
        given:
        Bear bear = testBear
        bear.eat(5)

        when:
        int newWeight = bear.getWeight()

        then:
        newWeight == expected

        where:
        testBear << [new BlackBear(10, DateTime.now()),
                     new BrownBear(5, DateTime.now()),
                     new PolarBear(20, DateTime.now())]
        expected << [15, 10, 25]
    }

    def "Bear should get on weight by 3/4 of waterWeight, which he was drinking"(){
        given:
        Bear bear = testBear
        bear.drink(waterW)
    }

}
