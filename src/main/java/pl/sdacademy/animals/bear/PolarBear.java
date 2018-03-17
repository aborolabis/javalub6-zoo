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
        DateTime startHibernating = new DateTime(clock.getCurrentTime().getYear(), 5, 5, 00, 00);
        DateTime endHibernating = new DateTime(clock.getCurrentTime().getYear(), 10, 10, 00, 00);
        return clock.getCurrentTime().isBefore(endHibernating) && clock.getCurrentTime().isAfter(startHibernating);
    }

    public PolarBear(int weight, BearClock clock) {
        super(weight, clock);
        this.clock = clock;
    }

}
