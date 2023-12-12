package subway.domain;

import java.util.HashSet;
import java.util.List;
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

    public static Relationship from(List<String> relationship) {
        try {
            Station station1 = new Station(relationship.get(0));
            Station station2 = new Station(relationship.get(1));
            int distance = Integer.parseInt(relationship.get(2));
            int minute = Integer.parseInt(relationship.get(3));
            return new Relationship(station1, station2, distance, minute);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
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
