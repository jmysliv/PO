package pl.edu.agh.to.lab4;

import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy {
    private final List<SearchStrategy> strategies;

    public CompositeSearchStrategy(List<SearchStrategy> strategies){
        this.strategies = strategies;
    }
    @Override
    public boolean filter(Suspect suspect) {
        return strategies.stream().allMatch(strategy -> strategy.filter(suspect));
    }
}
