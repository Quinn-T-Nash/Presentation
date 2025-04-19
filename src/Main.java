import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        Command command = new Command(editor);

        // Set initial state
        editor.setText("Hello World");

        // Save state before making changes
        command.makeBackup();

        // Make some changes
        editor.setText("Hello Java Memento Pattern");

        // Restore to previous state
        command.undo();

        command.redo();

        command.undo();

    }
}