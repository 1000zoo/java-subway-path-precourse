package subway.service;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.Station;

public class PathFinder {

    private final DijkstraShortestPath<Station, DefaultWeightedEdge> shortestDistancePath;
    private final DijkstraShortestPath<Station, DefaultWeightedEdge> shortestTimePath;

    public PathFinder(SubwayGraph graph) {
        this.shortestDistancePath = new DijkstraShortestPath<>(graph.getDistanceGraph());
        this.shortestTimePath = new DijkstraShortestPath<>(graph.getMinuteGraph());
    }

    public List<Station> findShortestDistancePath(Station from, Station to) {
        return shortestDistancePath.getPath(from, to).getVertexList();
    }

    public List<Station> findShortestMinutePath(Station from, Station to) {
        return shortestTimePath.getPath(from, to).getVertexList();
    }
}
