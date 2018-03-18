package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Time.BearClock;

public class PolarBear extends Bear {

    private BearClock clock;

    public PolarBear(int weight) {
        super(weight);
    }

    @Override
    public boolean isHibernating() {
        DateTime startHibernating = new DateTime(clock.getYear(), 5, 5, 0, 0);
        DateTime endHibernating = new DateTime(clock.getYear(), 10, 10, 0, 0);
        return clock.getCurrentTime().isBefore(endHibernating) && clock.getCurrentTime().isAfter(startHibernating);
    }

    public PolarBear(int weight, BearClock clock) {
        super(weight, clock);
        this.clock = clock;
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
