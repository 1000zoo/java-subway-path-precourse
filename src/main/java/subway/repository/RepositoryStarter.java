package subway.repository;

import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Relationship;
import subway.domain.RelationshipRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class RepositoryStarter {

    private static boolean init = false;

    private final static List<String> stationNames = List.of(
            "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
    );

    private final static Map<String, List<String>> lineNames = Map.of(
            "2호선", List.of("교대역", "강남역", "역삼역"),
            "3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"),
            "신분당선", List.of("강남역", "양재역", "양재시민의숲역")
    );

    private final static List<List<String>> informations = List.of(
            List.of("교대역", "강남역", "2", "3"),
            List.of("강남역", "역삼역", "2", "3"),    //2호선

            List.of("교대역", "남부터미널역", "3", "2"),
            List.of("남부터미널역", "양재역", "6", "5"),
            List.of("양재역", "매봉역", "1", "1"),    //3호선

            List.of("강남역", "양재역", "2", "8"),
            List.of("양재역", "양재시민의숲역", "10", "3")    //신분당선
    );

    private RepositoryStarter() {
    }

    public static void init() {
        if (init) {
            return;
        }
        init = true;
        createStationRepository();
        createLineRepository();
        createRelationshipRepository();
    }

    private static void createStationRepository() {
        for (String name : stationNames) {
            Station station = new Station(name);
            StationRepository.addStation(station);
        }
    }

    private static void createLineRepository() {
        for (Map.Entry<String, List<String>> entry : lineNames.entrySet()) {
            Line line = new Line(entry.getKey());
            lineAdder(line, entry.getValue());
            LineRepository.addLine(line);
        }
    }

    private static void lineAdder(Line line, List<String> stationNames) {
        for (String name : stationNames) {
            line.addStation(name);
        }
    }

    private static void createRelationshipRepository() {
        for (List<String> information : informations) {
            Relationship relationship = Relationship.from(information);
            RelationshipRepository.addRelationship(relationship);
        }
    }
}
