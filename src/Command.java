//The caretaker. When undo is requested, it restores the originator's state from a memento.

import java.util.ArrayList;
import java.util.List;

class Command {

    private List<Snapshot> backups;
    private Editor editor;
    private List<Snapshot> redos;

    public Command(Editor editor) {
        this.editor = editor;
        this.backups = new ArrayList<>();
        this.redos = new ArrayList<>();
    }

    public void makeBackup() {
        backups.add(editor.createSnapshot());
    }

    public void undo() {

        //add what you are undoing
        redos.add(editor.createSnapshot());

        if (backups != null && !backups.isEmpty()) {
            int lastIndex = backups.size() - 1;
            Snapshot lastBackup = backups.get(lastIndex);
            lastBackup.restore();
            backups.remove(lastIndex);
        }
    }

    public void redo()
    {

        backups.add(editor.createSnapshot());

        if (redos != null && !redos.isEmpty()) {
            int lastIndex = redos.size() - 1;
            Snapshot lastBackup = redos.get(lastIndex);
            lastBackup.restore();

            redos.remove(lastIndex);
        }

    }
}