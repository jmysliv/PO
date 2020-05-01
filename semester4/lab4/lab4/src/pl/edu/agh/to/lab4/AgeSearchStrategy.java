package pl.edu.agh.to.lab4;

public class AgeSearchStrategy implements SearchStrategy {
    private int min;
    private int max;

    public AgeSearchStrategy(int min, int max){
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() >= min && suspect.getAge() <= max;
    }

}
