package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RelationshipRepositoryTest {

    @BeforeEach
    void setUp() {
        RelationshipRepository.deleteAll();
        Station station1 = new Station("강남역");
        Station station2 = new Station("역삼역");
        int km = 2;
        int minute = 3;
        Relationship relationship = new Relationship(station1, station2, km, minute);
        RelationshipRepository.addRelationship(relationship);
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