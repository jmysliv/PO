package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;
    private List<SuspectAggregate> aggregates = Arrays.asList(new PersonDataProvider(), new PrisonersDataProvider());
    private Finder suspectFinder = new Finder(new CompositeAggregate(aggregates));

    @Test
    public void testDisplayingNotJailedPrisoner() {
        suspectFinder.display(new NameSearchStrategy("Janusz"));
        assertContentIsDisplayed("Janusz Podejrzany");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        suspectFinder.display(new NameSearchStrategy("Jan"));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        suspectFinder.display(new NameSearchStrategy("Janusz"));
        assertContentIsNotDisplayed("Janusz Gimbus");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        suspectFinder.display(new NameSearchStrategy("Adam"));
        assertContentIsNotDisplayed("Adam Future");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

}
