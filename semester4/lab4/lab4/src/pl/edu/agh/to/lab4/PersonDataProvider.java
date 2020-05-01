package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class PersonDataProvider implements SuspectAggregate {

    private final Collection<CracovCitizen> cracovCitizens = new ArrayList<CracovCitizen>();

    public PersonDataProvider() {
        cracovCitizens.add(new CracovCitizen("Jan", "Kowalski", 30));
        cracovCitizens.add(new CracovCitizen("Janusz", "Krakowski", 30));
        cracovCitizens.add(new CracovCitizen("Janusz", "Mlodociany", 10));
        cracovCitizens.add(new CracovCitizen("Kasia", "Kosinska", 19));
        cracovCitizens.add(new CracovCitizen("Piotr", "Zgredek", 29));
        cracovCitizens.add(new CracovCitizen("Tomek", "Gimbus", 14));
        cracovCitizens.add(new CracovCitizen("Janusz", "Gimbus", 15));
        cracovCitizens.add(new CracovCitizen("Alicja", "Zaczarowana", 22));
        cracovCitizens.add(new CracovCitizen("Janusz", "Programista", 77));
        cracovCitizens.add(new CracovCitizen("Pawel", "Pawlowicz", 32));
        cracovCitizens.add(new CracovCitizen("Krzysztof", "Mendel", 30));
    }

    public Collection<CracovCitizen> getAllCracovCitizens() {
        return cracovCitizens;
    }

    @Override
    public Iterator<Suspect> getIterator() {
        Collection<Suspect> suspects = cracovCitizens.stream().map( x -> (Suspect) x).collect(Collectors.toList());
        return suspects.iterator();
    }
}
