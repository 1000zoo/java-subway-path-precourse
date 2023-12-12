package subway.controller;

import subway.service.SubwayGraph;
import subway.view.input.Input;

public class Controller {

    private final Input input;
    private final SubwayGraph graph;

    public Controller(Input input) {
        this.input = input;
        this.graph = new SubwayGraph();
    }

    public void start() {

    }
}
