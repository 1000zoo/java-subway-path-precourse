package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class Relationship {

    private final Set<Station> stationSet = new HashSet<>();
    private final int distance;
    private final int minute;

    public Relationship(Station station1, Station station2, int distance, int minute) {
        stationSet.add(station1);
        stationSet.add(station2);
        this.distance = distance;
        this.minute = minute;
    }

    public boolean containsBoth(Station station1, Station station2) {
        return stationSet.contains(station1) && stationSet.contains(station2);
    }

    public int getDistance() {
        return distance;
    }

    public int getMinute() {
        return minute;
    }
}
