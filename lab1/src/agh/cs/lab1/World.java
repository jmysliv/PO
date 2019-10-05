package agh.cs.lab1;


public class World {
    public static void main(String[] args) {
        System.out.println("System is starting");

        Direction[] directions = new Direction[args.length];
        for(int i=0; i < args.length;i++){
            directions[i] = swap(args[i]);
        }

        World.run(directions);
        World.moves(directions);
        System.out.println("Koniec");
    }

    public static void run(String[] args){
        int counter = 0;
        for(String x: args ){
            switch(x){
                case "f":
                    System.out.print("Zwierze idzie do przodu");
                    break;
                case "b":
                    System.out.print("Zwierze idzie do tyłu");
                    break;
                case "r":
                    System.out.print("Zwierze idzie w prawo");
                    break;
                case "l":
                    System.out.print("Zwierze idzie w lewo");
                    break;
            }
            counter++;
            if(counter != args.length )
                System.out.print(", ");
            else
                System.out.println();

        }
    }

    public static Direction swap(String x){
        switch(x){
            case "f":
                return Direction.FORWARD;
            break;
            case "b":
                return Direction.BACKWARD;
            break;
            case "r":
                return Direction.RIGHT;
            break;
            case "l":
                return Direction.LEFT;
            break;

            default:
                return Direction.NAN;
        }
    }

    public static void moves(Direction[] directions){
        int counter = 0;
        for(Direction x: directions ){
            switch(x){
                case FORWARD:
                    System.out.print("FORWARD");
                    break;
                case BACKWARDS:
                    System.out.print("BACKWARDS");
                    break;
                case RIGHT:
                    System.out.print("RIGHT");
                    break;
                case LEFT:
                    System.out.print("LEFT");
                    break;

                default:
                    System.out.print("WRONG DIRECTION");
            }
            counter++;
            if(counter != args.length )
                System.out.print(", ");
            else
                System.out.println();
        }
    }
}
