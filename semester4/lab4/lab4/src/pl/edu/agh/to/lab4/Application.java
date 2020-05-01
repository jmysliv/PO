package pl.edu.agh.to.lab4;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<SuspectAggregate> aggregates = Arrays.asList(new PersonDataProvider(), new PrisonersDataProvider());
        Finder suspects = new Finder(new CompositeAggregate(aggregates));
        suspects.displayAllSuspectsWithName("Janusz");
    }
}
