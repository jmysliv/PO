public class PasteCommand extends Command{
    public PasteCommand(Editor editor, Application app) {
        super(editor, app);
    }

    @Override
    public void execute() {
        super.execute();
        this.editor.replaceSelection(this.app.getClipboard());
    }
}
