package subway.view.input;

import java.util.Scanner;

public abstract class Input<O> {

    protected final Scanner scanner;

    protected Input(Scanner scanner) {
        this.scanner = scanner;
    }

    protected O read() {
        String input = scanner.nextLine();
        validate(input);
        return transfer(input);
    }

    protected abstract void validate(String input);

    protected abstract O transfer(String input);
}
