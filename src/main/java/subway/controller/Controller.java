package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.constance.InstructionMessages;
import subway.domain.Station;
import subway.service.PathFinder;
import subway.service.SubwayGraph;
import subway.view.Output;
import subway.view.input.Input;
import subway.view.input.MainInput;
import subway.view.input.SelectInput;
import subway.view.input.StationInput;

public class Controller {

    private final Scanner scanner;
    private final PathFinder finder;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
        this.finder = new PathFinder(new SubwayGraph());
    }

    public void start() {
        Input<Boolean> input = new MainInput(scanner);
        Output.print(InstructionMessages.MAIN_INSTRUCTION.getMessage());
        Output.print(InstructionMessages.SELECT_MESSAGE.getMessage());
        try {
            if (input.read()) {
                selectPath();
                start();
            }
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            start();
        }
    }

    public void selectPath() {
        Input<Integer> input = new SelectInput(scanner);
        Output.print(InstructionMessages.STANDARD_INSTRUCTION.getMessage());
        Output.print(InstructionMessages.SELECT_MESSAGE.getMessage());
        try {
            int menu = input.read();
            if (menu == 1) {
                distancePath();
                return;
            }
            if (menu == 2) {
                minutePath();
                return;
            }
            start();
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            selectPath();
        }
    }

    private void distancePath() {
        StationInput input = new StationInput(scanner);
        try {
            Station from = input.read();
            Station to = input.read();
            printResult(finder.findShortestDistancePath(from, to));
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            selectPath();
        }
    }

    private void minutePath() {
        StationInput input = new StationInput(scanner);
        try {
            Station from = input.read();
            Station to = input.read();
            printResult(finder.findShortestMinutePath(from, to));
        } catch (IllegalArgumentException exception) {
            Output.print(exception.getMessage());
            selectPath();
        }
    }

    private void printResult(List<Station> stations) {

    }
}
