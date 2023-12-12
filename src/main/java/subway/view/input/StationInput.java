package subway.view.input;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationInput extends Input<Station> {

    public StationInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void validate(String input) {

    }

    @Override
    protected Station transfer(String input) {
        return StationRepository.findByName(input);
    }
}
