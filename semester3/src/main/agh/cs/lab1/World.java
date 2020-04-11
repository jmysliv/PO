package agh.cs.lab1;


public class World {
    public static void main(String[] args) {
        System.out.println("System is starting");

        Direction[] directions = new Direction[args.length];
        for(int i=0; i < args.length;i++){
            directions[i] = swap(args[i]);
        }

        World.run(args);
        World.moves(directions);
        System.out.println("System shut down");
    }

    public static void run(String[] args){
        int counter = 0;

        for(String x: args ){
            if((x.equals("f") || x.equals("b") || x.equals("r") || x.equals("l")) && counter>0)
                System.out.print(", ");
            counter++;
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
                    default:
                        counter--;

            }


        }
        System.out.println();
    }

    public static Direction swap(String x){
        switch(x){
            case "f":
                return Direction.FORWARD;

            case "b":
                return Direction.BACKWARD;

            case "r":
                return Direction.RIGHT;

            case "l":
                return Direction.LEFT;


            default:
                return Direction.WRONG;
        }
    }

    public static void moves(Direction[] directions){
        int counter = 0;
        for(Direction x: directions ){
            if((x==Direction.FORWARD || x==Direction.BACKWARD || x==Direction.LEFT || x==Direction.RIGHT) && counter>0)
                System.out.print(", ");
            counter++;
            switch(x){
                case FORWARD:
                    System.out.print("FORWARD");
                    break;
                case BACKWARD:
                    System.out.print("BACKWARD");
                    break;
                case RIGHT:
                    System.out.print("RIGHT");
                    break;
                case LEFT:
                    System.out.print("LEFT");
                    break;

                    default:
                        counter--;

            }

        }
        System.out.println();
    }
}
