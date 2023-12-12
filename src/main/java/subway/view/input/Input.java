package subway.view.input;

import java.util.Scanner;

public abstract class Input<O> {

    protected final Scanner scanner;

    protected Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public O read() {
        String input = scanner.nextLine();
        try {
            validate(input);
            return transfer(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    protected abstract void validate(String input);

    protected abstract O transfer(String input);
}
