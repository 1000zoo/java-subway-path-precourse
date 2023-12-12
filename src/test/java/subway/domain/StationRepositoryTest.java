package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @BeforeEach
    private void setUp() {
        StationRepository.deleteAll();
    }

    @Test
    void findByName() {
        Station station = new Station("역삼역");
        StationRepository.addStation(station);

        Station result = StationRepository.findByName("역삼역");
        assertThat(result.getName()).isEqualTo(station.getName());
    }

    @Test
    void findByNameError() {
        Station station = new Station("역삼역");
        StationRepository.addStation(station);

        assertThrows(
                IllegalArgumentException.class,
                () -> StationRepository.findByName("내방역")
        );
    }
}