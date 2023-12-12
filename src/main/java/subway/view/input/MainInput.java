package subway.view.input;

import java.util.Scanner;
import subway.constance.ErrorMessages;

public class MainInput extends Input<Boolean> {
    public MainInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void validate(String input) {
        if (!input.equals("1") && !input.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT.getMessage());
        }
    }

    @Override
    protected Boolean transfer(String input) {
        return input.equals("1");
    }

}
