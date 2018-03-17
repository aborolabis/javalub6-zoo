package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Time.BearClock;

public class BrownBear extends Bear {

    public BrownBear(int weight) {
        super(weight);
    }

    @Override
    public boolean isHibernating() {
        return false;
    }

    public BrownBear(int weight, BearClock currentTime) {
        super(weight, currentTime);
    }

}
