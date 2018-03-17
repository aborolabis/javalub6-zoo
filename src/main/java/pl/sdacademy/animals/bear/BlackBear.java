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
        DateTime startHibernating = new DateTime(clock.getCurrentTime().getYear(), 11, 20, 00, 00);
        DateTime endHibernating = new DateTime(clock.getCurrentTime().getYear(), 3, 15, 00, 00);
        return clock.getCurrentTime().isBefore(endHibernating) || clock.getCurrentTime().isAfter(startHibernating);
    }
}