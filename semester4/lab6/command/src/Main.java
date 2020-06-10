public class Main {
    public static void main(String []args){
        Application app = new Application();
        Editor editor = new Editor("example text");
        CopyCommand command = new CopyCommand(editor, app);
        editor.setSelection(0, 8);
        app.executeCommand(command);
        System.out.println(editor.getText());
        editor.setSelection(7, 8);
        PasteCommand command1 = new PasteCommand(editor, app);
        app.executeCommand(command1);
        System.out.println(editor.getText());
        editor.setSelection(0, 7);
        CutCommand command2 = new CutCommand(editor, app);
        app.executeCommand(command2);
        System.out.println(editor.getText());
        app.undo();
        System.out.println(editor.getText());
        app.undo();
        System.out.println(editor.getText());
        app.undo();
        System.out.println(editor.getText());
    }
}
