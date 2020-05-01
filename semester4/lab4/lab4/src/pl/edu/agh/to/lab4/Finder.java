package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;

public class Finder {
    private CompositeAggregate compositeAggregate;

    public Finder( CompositeAggregate compositeAggregate) {
       this.compositeAggregate = compositeAggregate;
    }

    public void display(SearchStrategy strategy) {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();

        Iterator<Suspect> iterator = compositeAggregate.getIterator();
        while(iterator.hasNext()) {
            Suspect suspect = iterator.next();
            if (suspect.isSuspected() && strategy.filter(suspect)) {
                suspects.add(suspect);
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect suspect : suspects) {
            System.out.println(suspect.display());
        }
    }
}
