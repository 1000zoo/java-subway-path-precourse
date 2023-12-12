package subway.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.Station;

class PathFinderTest {

    private PathFinder pathFinder;

    @BeforeEach
    void setUp() {
        SubwayGraph graph = new SubwayGraph();
        pathFinder = new PathFinder(graph);
    }

    @ParameterizedTest
    @DisplayName("최단거리 역 개수 테스트")
    @CsvSource(value = {
            "역삼역,남부터미널역,4",
            "매봉역,교대역,4",
            "매봉역,강남역,3",
            "매봉역,역삼역,4",
            "매봉역,양재시민의숲역,3",
    }, delimiter = ',')
    void shortestDistanceTest(String fromName, String toName, int answer) {
        Station from = new Station(fromName);
        Station to = new Station(toName);

        List<Station> list = pathFinder.findShortestDistancePath(from, to);
        assertThat(list.size()).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("최단시간 역 개수 테스트")
    @CsvSource(value = {
            "역삼역,남부터미널역,4",
            "매봉역,교대역,4",
            "매봉역,강남역,3",
            "매봉역,역삼역,4",
            "매봉역,양재시민의숲역,3",
    }, delimiter = ',')
    void shortestTimeTest(String fromName, String toName, int answer) {
        Station from = new Station(fromName);
        Station to = new Station(toName);

        List<Station> list = pathFinder.findShortestDistancePath(from, to);
        assertThat(list.size()).isEqualTo(answer);
    }
}