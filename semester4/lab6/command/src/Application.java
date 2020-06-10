import java.lang.reflect.Array;
import java.util.ArrayList;

public class Application {
    private ArrayList<Editor> editors;
    private Editor activeEditor;
    private String clipboard;
    private CommandHistory history;

    public Application(){
        this.history = new CommandHistory();
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public void executeCommand(Command command){
        history.push(command);
    }

    public void undo(){
        history.pop();
    }
}
