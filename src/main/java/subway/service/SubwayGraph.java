package subway.service;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Relationship;
import subway.domain.RelationshipRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.repository.RepositoryStarter;

public class SubwayGraph {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    private final WeightedMultigraph<Station, DefaultWeightedEdge> minuteGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public SubwayGraph() {
        RepositoryStarter.init();
        setGraph();
        setDistanceGraph();
        setMinuteGraph();
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getDistanceGraph() {
        return distanceGraph;
    }

    public WeightedMultigraph<Station, DefaultWeightedEdge> getMinuteGraph() {
        return minuteGraph;
    }

    private void setGraph() {
        for (Station station : StationRepository.stations()) {
            distanceGraph.addVertex(station);
            minuteGraph.addVertex(station);
        }
    }

    private void setDistanceGraph() {
        for (Relationship relationship : RelationshipRepository.relationships()) {
            List<Station> stations = relationship.stations();
            distanceGraph.setEdgeWeight(distanceGraph.addEdge(stations.get(0), stations.get(1)),
                    relationship.getDistance());
        }
    }

    private void setMinuteGraph() {
        for (Relationship relationship : RelationshipRepository.relationships()) {
            List<Station> stations = relationship.stations();
            distanceGraph.setEdgeWeight(distanceGraph.addEdge(stations.get(0), stations.get(1)),
                    relationship.getMinute());
        }

    }
}
