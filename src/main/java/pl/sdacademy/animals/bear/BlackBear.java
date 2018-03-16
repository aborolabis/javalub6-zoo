package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;

public class BlackBear extends Bear {

    private DateTime currentTime;

    public BlackBear(int weight, DateTime currentTime) {
        super(weight, currentTime);
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }
}