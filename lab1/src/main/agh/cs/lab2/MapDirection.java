package agh.cs.lab2;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString(){
        switch (this){
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case EAST:
                return "Wschód";
            case WEST:
                return "zachód";

                default:
                    return "Error";
        }
    }
     public MapDirection next(){
         switch (this){
             case NORTH:
                 return EAST;
             case SOUTH:
                 return WEST;
             case EAST:
                 return SOUTH;
             case WEST:
                 return NORTH;

             default:
                 return NORTH;
         }
     }

    public MapDirection previous(){
        switch (this){
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            default:
                return SOUTH;
        }
    }

    public Vector2d toUnitVector(){
        switch (this){
            case NORTH:
                Vector2d result = new Vector2d(0, 1);
                return result;
            case SOUTH:
                Vector2d result1 = new Vector2d(0, -1);
                return result1;
            case EAST:
                Vector2d result2 = new Vector2d(1, 0);
                return result2;
            case WEST:
                Vector2d result3 = new Vector2d(-1, 0);
                return result3;
            default:
                Vector2d result4 = new Vector2d(0, 0);
                return result4;
        }
    }

}
