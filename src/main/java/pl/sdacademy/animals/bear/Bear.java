package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Animal;

public abstract class Bear implements Animal {

    private int weight;
    private boolean isAlive;
    private DateTime feedingTime;

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
        this.feedingTime = DateTime.now();
    }

    @Override
    public boolean isAlive() {
        DateTime currentTime = DateTime.now();
        DateTime dateWhenBearShouldBeDead = feedingTime.plusDays(10);
        if(dateWhenBearShouldBeDead.isBefore(currentTime)){
            this.isAlive = false;
        }
        return isAlive;
    }

    public void eat() {
        feedingTime = DateTime.now();
    }

    @Override
    public int getWeight() {
        return weight;
    }

}
