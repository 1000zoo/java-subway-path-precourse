package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RelationshipRepository {

    private final static List<Relationship> relationships = new ArrayList<>();

    public static void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public static void deleteAll() {
        relationships.clear();
    }

    public static List<Relationship> relationships() {
        return Collections.unmodifiableList(relationships);
    }

    public static int getDistanceBetween(Station station1, Station station2) {
        Relationship relationship = findRelationship(station1, station2);
        return relationship.getDistance();
    }

    public static int getMinuteBetween(Station station1, Station station2) {
        Relationship relationship = findRelationship(station1, station2);
        return relationship.getMinute();
    }

    private static Relationship findRelationship(Station station1, Station station2) {
        return relationships.stream()
                .filter(relationship -> relationship.containsBoth(station1, station2))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
