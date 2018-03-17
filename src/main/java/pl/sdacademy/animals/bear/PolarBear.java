package pl.sdacademy.animals.bear;

import pl.sdacademy.animals.Time.BearClock;

public class PolarBear extends Bear {

    public PolarBear(int weight) {
        super(weight);
    }

    @Override
    public boolean isHibernating() {
        return false;
    }

    public PolarBear(int weight, BearClock currentTime) {
        super(weight, currentTime);
    }

}
