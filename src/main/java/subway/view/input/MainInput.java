package subway.view.input;

import java.util.Scanner;

public class MainInput extends Input<String> {
    protected MainInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void validate(String input) {
        if (!input.equals("1") && input.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected String transfer(String input) {
        return null;
    }

}
