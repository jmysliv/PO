import java.util.ArrayList;

public class CommandHistory {
    private ArrayList<Command> history;

    public CommandHistory(){
        this.history = new ArrayList<>();
    }

    public void push(Command command){
        this.history.add(command);
        command.execute();
    }

    public Command pop(){
        try{
            Command command = this.history.get(this.history.size() - 1);
            this.history.remove(this.history.size() - 1);
            command.undo();
            return command;
        } catch(IndexOutOfBoundsException ignored){
            return null;
        }
    }
}
