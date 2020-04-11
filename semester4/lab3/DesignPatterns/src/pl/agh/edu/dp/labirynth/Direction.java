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

    public static Direction getNext(Direction direction){
        switch(direction){
            case East:
                return South;
            case West:
                return  North;
            case North:
                return East;
            case South:
                return West;
            default:
                return North;
        }
    }

    public static Direction getPrevious(Direction direction){
        switch(direction){
            case East:
                return North;
            case West:
                return  South;
            case North:
                return West;
            case South:
                return East;
            default:
                return North;
        }
    }
}