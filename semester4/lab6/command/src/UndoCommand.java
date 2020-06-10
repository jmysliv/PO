public class UndoCommand extends Command{
    public UndoCommand(Editor editor, Application app) {
        super(editor, app);
    }

    @Override
    public void execute() {
        super.undo();
    }
}
