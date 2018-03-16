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

    public Bear(int weight, BearClock clock) {
        this.weight = weight;
        this.isAlive = true;
        this.feedingTime = clock.getCurrentTime();
        this.clock = clock;
    }

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
        this.feedingTime = clock.getCurrentTime();
        this.clock = new BearClock();
    }

    @Override
    public boolean isAlive() {
        DateTime dateWhenBearShouldBeDead = feedingTime.plusDays(10);
        if(dateWhenBearShouldBeDead.isBefore(clock.getCurrentTime())){
            this.isAlive = false;
        }
        return isAlive;
    }

    public void eat(int foodWeight) {
        feedingTime = clock.getCurrentTime();
        this.foodWeight = foodWeight;
    }

    public void drink(double waterWeight){
        this.waterWeight = waterWeight;
    }

    @Override
    public double getWeight() {
        return weight+foodWeight+(waterWeight*3/4);
    }

}
