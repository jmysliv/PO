public class CutCommand extends Command {
    public CutCommand(Editor editor, Application app) {
        super(editor, app);
    }

    @Override
    public void execute() {
        super.execute();
        this.app.setClipboard(this.editor.getSelection());
        this.editor.deleteSelection();
    }
}
