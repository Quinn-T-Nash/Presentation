// The memento stores the past state of the editor.

public class Snapshot {
    private final Editor editor;
    private final String text;

    //remove cursor and selection cause it doesn't really matter for us

    public Snapshot(Editor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    // At some point, a previous state of the editor can be
    // restored using a memento object.
    public void restore() {
        editor.setText(text);
    }
}
