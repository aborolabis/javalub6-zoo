package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.Time.BearClock;

public abstract class Bear implements Animal {

    private int weight;
    private boolean isAlive;
    private DateTime feedingTime;
    private BearClock clock;
    private int foodWeight;
    private double waterWeight;
    private double loosingWeight;

    public Bear(int weight, BearClock clock) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = clock;
        this.feedingTime = clock.getCurrentTime();

    }

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = new BearClock();
        this.feedingTime = this.clock.getCurrentTime();
    }

    @Override
    public boolean isAlive() {
        DateTime dateWhenBearShouldBeDead = feedingTime.plusDays(10);
        if(clock.getCurrentTime().isAfter(dateWhenBearShouldBeDead)){
            this.isAlive = false;
        }
        return isAlive;
    }

    public void eat(int foodWeight) throws BearHibernatingException {
        feedingTime = clock.getCurrentTime();
        this.foodWeight = foodWeight;
    }

    public void drink(double waterWeight) throws BearHibernatingException {
        this.waterWeight = waterWeight *3/4;
    }

    @Override
    public double getWeight() {
        return weight+foodWeight+waterWeight-loosingWeight;
    }

    public void poop(){
        this.loosingWeight = (this.weight * 0.05);
    }

    public abstract boolean isHibernating();
}
