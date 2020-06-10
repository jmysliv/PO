import java.util.ArrayList;

public class Command {
    protected Editor editor;
    protected Application app;
    private ArrayList<String> backup;

    public Command(Editor editor, Application app) {
        this.editor = editor;
        this.app = app;
        this.backup = new ArrayList<>();
    }

    public void saveBackup(){
        //save to file?
    }

    public void execute(){
        this.backup.add(this.editor.getText());
    }

    public void undo(){
        try{
            this.editor.setText(this.backup.get(backup.size() - 1));
            this.backup.remove(this.backup.size() -1);
        } catch(IndexOutOfBoundsException ignored){

        }

    }
}
