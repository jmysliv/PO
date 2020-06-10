public class CopyCommand extends Command{
    public CopyCommand(Editor editor, Application app) {
        super(editor, app);
    }

    @Override
    public void execute() {
        super.execute();
        this.app.setClipboard(this.editor.getSelection());
    }
}
