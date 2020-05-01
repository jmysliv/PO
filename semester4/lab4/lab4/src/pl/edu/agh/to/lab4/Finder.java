package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    private SuspectAggregate personDataProvider;
    private SuspectAggregate prisonersDataProvider;

    public Finder(SuspectAggregate personDataProvider, SuspectAggregate prisonersDataProvider) {
       this.personDataProvider = personDataProvider;
       this.prisonersDataProvider = prisonersDataProvider;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();

        Iterator<Suspect> prisonerIterator = prisonersDataProvider.getIterator();
        while(prisonerIterator.hasNext()) {
            Suspect suspect = prisonerIterator.next();
            if (suspect.isSuspected() && suspect.getFirstname().equals(name)) {
                suspects.add(suspect);
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        if (suspects.size() < 10) {
            Iterator<Suspect> personIterator = personDataProvider.getIterator();
            while(personIterator.hasNext()) {
                Suspect suspect = personIterator.next();
                if (suspect.isSuspected() && suspect.getFirstname().equals(name)) {
                    suspects.add(suspect);
                }
                if (suspects.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect suspect : suspects) {
            System.out.println(suspect.display());
        }
    }
}
