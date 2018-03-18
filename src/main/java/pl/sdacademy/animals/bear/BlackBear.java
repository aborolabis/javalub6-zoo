package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import pl.sdacademy.animals.Time.BearClock;


public class BlackBear extends Bear {

    public BearClock clock;

    public BlackBear(int weight) {
        super(weight);
    }

    public BlackBear(int weight, BearClock currentTime) {
        super(weight, currentTime);
        this.clock = currentTime;
    }

    @Override
    public boolean isHibernating() {
        DateTime startHibernating = new DateTime(clock.getYear(), 11, 20, 0, 0);
        DateTime endHibernating = new DateTime(clock.getYear(), 3, 15, 0, 0);
        return clock.getCurrentTime().isBefore(endHibernating) || clock.getCurrentTime().isAfter(startHibernating);
    }

    @Override
    public void eat(int foodWeight) throws BearHibernatingException {
        if(!isHibernating()){
            super.eat(foodWeight);
        } else {
            throw new BearHibernatingException();
        }
    }

    @Override
    public void drink(double waterWeight) throws BearHibernatingException {
        if(!isHibernating()){
            super.drink(waterWeight);
        } else {
            throw new BearHibernatingException();
        }
    }

}