package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Station> stations = new ArrayList<>();

    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        stations.add(station);
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
}
