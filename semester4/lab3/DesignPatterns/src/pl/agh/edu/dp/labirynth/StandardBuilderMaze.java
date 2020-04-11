package pl.agh.edu.dp.labirynth;

public class StandardBuilderMaze implements  MazeBuilder {

    private Maze currentMaze;

    public StandardBuilderMaze(){
        this.currentMaze = new Maze();
    }

    @Override
    public Room createRoom() {
        Room room = new Room(currentMaze.getRoomNumbers());
        for(Direction direction : Direction.values()){
            room.setSide(direction, new Wall());
        }
        currentMaze.addRoom(room);
        return room;
    }

    @Override
    public void addDoorBetweenRooms(Room r1, Room r2) {
        Direction direction = commonWall(r1, r2);
        if(direction == null){
            return;
        }
        Door door = new Door(r1, r2);
        r1.setSide(direction, door);
        r2.setSide(Direction.getOpposite(direction), door);
    }

    @Override
    public void addWallBetweenRooms(Room r1, Room r2, Direction direction) {
        Wall wall = new Wall();
        r1.setSide(direction, wall);
        r2.setSide(Direction.getOpposite(direction), wall);
    }


    private Direction commonWall(Room r1, Room r2){
        for(Direction direction : Direction.values()){
            if(r1.getSide(direction).equals(r2.getSide(Direction.getOpposite(direction)))){
                return direction;
            }
        }
        return null;
    }

    public Maze getCurrentMaze() {
        return currentMaze;
    }
}
