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
        ArrayList<Prisoner> suspectedPrisoners = new ArrayList<Prisoner>();
        ArrayList<CracovCitizen> suspectedCracovCitizens = new ArrayList<CracovCitizen>();

        for (Collection<Prisoner> prisonerCollection : prisonersDatabase.findAll().values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (!prisoner.isJailedNow() && prisoner.getName().equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() >= 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (CracovCitizen cracovCitizen :personDataProvider.getAllCracovCitizens()) {
                if (cracovCitizen.getAge() > 18 && cracovCitizen.getFirstname().equals(name)) {
                    suspectedCracovCitizens.add(cracovCitizen);
                }
                if (suspectedPrisoners.size() + suspectedCracovCitizens.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedCracovCitizens.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n.display());
        }

        for (CracovCitizen p : suspectedCracovCitizens) {
            System.out.println(p.display());
        }
    }
}
