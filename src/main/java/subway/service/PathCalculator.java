package subway.service;

import java.util.List;
import subway.domain.RelationshipRepository;
import subway.domain.Station;

public class PathCalculator {

    private final List<Station> stations;

    public PathCalculator(List<Station> stations) {
        this.stations = stations;
    }

    public int getTotalDistance() {
        int total = 0;

        for (int i = 0; i < stations.size() - 1; i++) {
            total += RelationshipRepository.getDistanceBetween(stations.get(i), stations.get(i + 1));
        }

        return total;
    }

    public int getTotalMinute() {
        int total = 0;

        for (int i = 0; i < stations.size() - 1; i++) {
            total += RelationshipRepository.getMinuteBetween(stations.get(i), stations.get(i + 1));
        }

        return total;
    }
}
