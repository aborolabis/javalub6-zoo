package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import spock.lang.Specification

class BearSpec extends Specification {

    def "Bear should be alive immediately after creation"() {
        given:
        DateTime currentTime = DateTime.now()
        int weight = 3
        Bear bear = new BlackBear(weight, currentTime)

        when:
        boolean  result = bear.isAlive()

        then:
        result
    }

    def "Bear should be alive if it has eaten within 10 days"() {
        given:
        DateTime currentTime = DateTime.now()
        int weight = 3
        Bear bear = new BlackBear(weight, currentTime)
        bear.eat()

        when:
        boolean result = bear.isAlive()

        then:
        result
    }

    def "Bear should not be alive if it has eaten within more than 10 days"() {
        given:
        DateTime currentTime = DateTime.now().plusDays(20)
        int weight = 3
        Bear bear = new BlackBear(weight, currentTime)
        bear.eat()

        when:
        boolean result = bear.isAlive()

        then:
        !result
    }

}
