package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CompositeAggregate implements SuspectAggregate {
    private List<SuspectAggregate> aggregates;

    CompositeAggregate(List<SuspectAggregate> aggregates){
        this.aggregates = aggregates;
    }

    public Iterator<Suspect> getIterator(){
        return aggregates.stream().flatMap(x -> StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        x.getIterator(), Spliterator.ORDERED), false)).collect(Collectors.toList()).iterator();
    }
}
