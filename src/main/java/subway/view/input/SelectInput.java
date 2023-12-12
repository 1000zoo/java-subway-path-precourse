package subway.view.input;

import java.util.Scanner;
import subway.constance.ErrorMessages;

public class SelectInput extends Input<Integer> {

    public SelectInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void validate(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("B")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT.getMessage());
        }
    }

    @Override
    protected Integer transfer(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }
}
