package pl.sdacademy.animals.Time;

import org.joda.time.DateTime;

public class BearClock {

    public DateTime getCurrentTime(){
        return DateTime.now();
    }

    public int getYear(){
        return DateTime.now().getYear();
    }
}
