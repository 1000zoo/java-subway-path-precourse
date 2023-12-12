package subway.controller;

import static subway.constance.InstructionMessages.FROM_INSTRUCTION;
import static subway.constance.InstructionMessages.MAIN_INSTRUCTION;
import static subway.constance.InstructionMessages.RESULT_INSTRUCTION;
import static subway.constance.InstructionMessages.SELECT_MESSAGE;
import static subway.constance.InstructionMessages.STANDARD_INSTRUCTION;
import static subway.constance.InstructionMessages.TO_INSTRUCTION;

import subway.view.Output;

public class OutputController {

    private final Output output = new Output();

    public void printMainMessage() {
        output.print(MAIN_INSTRUCTION.getMessage());
    }

    public void printStandardMessage() {
        output.print(STANDARD_INSTRUCTION.getMessage());
    }

    public void printSelectMessage() {
        output.print(SELECT_MESSAGE.getMessage());
    }

    public void printFromInstructionMessage() {
        output.print(FROM_INSTRUCTION.getMessage());
    }

    public void printToInstructionMessage() {
        output.print(TO_INSTRUCTION.getMessage());
    }

    public void printResultInstructionMessage() {
        output.print(RESULT_INSTRUCTION.getMessage());
    }
}
