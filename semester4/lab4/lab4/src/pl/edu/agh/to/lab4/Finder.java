package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Finder {
    private PersonDataProvider personDataProvider;
    private PrisonersDatabase prisonersDatabase;

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
       this.personDataProvider = personDataProvider;
       this.prisonersDatabase = prisonersDatabase;
    }

    public void displayAllSuspectsWithName(String name) {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();

        for (Collection<Prisoner> prisonerCollection : prisonersDatabase.findAll().values()) {
            for (Suspect suspect : prisonerCollection) {
                if (suspect.isSuspected() && suspect.getFirstname().equals(name)) {
                    suspects.add(suspect);
                }
                if (suspects.size() >= 10) {
                    break;
                }
            }
        }

        if (suspects.size() < 10) {
            for (Suspect suspect :personDataProvider.getAllCracovCitizens()) {
                if (suspect.isSuspected() && suspect.getFirstname().equals(name)) {
                    suspects.add(suspect);
                }
                if (suspects.size() > 10) {
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
