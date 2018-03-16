package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Animal;

public abstract class Bear implements Animal {

    private int weight;
    private boolean isAlive;
    private DateTime feedingTime;
    private DateTime currentTime;
    private int foodWeight;

    public Bear(int weight, DateTime currentTime) {
        this.weight = weight;
        this.isAlive = true;
        this.feedingTime = DateTime.now();
        this.currentTime = currentTime;
    }

    @Override
    public boolean isAlive() {
        DateTime dateWhenBearShouldBeDead = feedingTime.plusDays(10);
        if(dateWhenBearShouldBeDead.isBefore(currentTime)){
            this.isAlive = false;
        }
        return isAlive;
    }

    public void eat(int foodWeight) {
        feedingTime = DateTime.now();
        this.foodWeight = foodWeight;
    }

    @Override
    public int getWeight() {
        return weight+foodWeight;
    }

}
