package subway.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.RelationshipRepository;
import subway.domain.Station;

class RepositoryStarterTest {

    @BeforeEach
    void setUp() {
        RepositoryStarter.init();
    }

    @Test
    void getDistanceBetween() {
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        int distance = RelationshipRepository.getDistanceBetween(station1, station2);
        Assertions.assertThat(distance).isEqualTo(2);
    }

    @Test
    void getMinuteBetween() {
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        int distance = RelationshipRepository.getMinuteBetween(station1, station2);
        Assertions.assertThat(distance).isEqualTo(3);
    }

}