package subway.controller;

import java.util.Scanner;
import subway.constance.InstructionMessages;
import subway.service.SubwayGraph;
import subway.view.Output;
import subway.view.input.Input;
import subway.view.input.MainInput;

public class Controller {

    private final Scanner scanner;
    private final SubwayGraph graph;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
        this.graph = new SubwayGraph();
    }

    public void start() {
        Output.print(InstructionMessages.MAIN_INSTRUCTION.getMessage());
        Output.print(InstructionMessages.SELECT_MESSAGE.getMessage());
        while (true) {
            Input<Boolean> input = new MainInput(scanner);
            if (!input.read()) {
                break;
            }
            selectPath();
        }
    }

    public void selectPath() {
        System.out.println("!!!!");
    }
}
