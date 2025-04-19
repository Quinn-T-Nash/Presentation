// The originator holds some data that may change over time.

public class Editor {
    private String text;

    public void setText(String text) {
        this.text = text;
        showText();
    }

    // Saves the current state inside a memento.
    public Snapshot createSnapshot() {
        return new Snapshot(this, text);
    }

    public void showText() {
        System.out.println(text + "\n");
    }

}
