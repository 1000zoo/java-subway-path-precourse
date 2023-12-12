package subway.view.input;

import java.util.Scanner;
import subway.view.Output;

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
            Output.print(exception.getMessage());
            return read();
        }
    }

    protected abstract void validate(String input);

    protected abstract O transfer(String input);
}
