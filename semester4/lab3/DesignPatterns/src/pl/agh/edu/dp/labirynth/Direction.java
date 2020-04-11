package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction getOpposite(Direction direction){
        switch(direction){
            case East:
                return West;
            case West:
                return  East;
            case North:
                return South;
            case South:
                return North;
            default:
                return North;
        }
    }
}