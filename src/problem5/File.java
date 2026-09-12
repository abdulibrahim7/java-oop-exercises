package problem5;

import java.util.Objects;

/** A simulated file whose lifetime is controlled by its owning folder. */
public class File {
    private String name;
    private final Folder parent;
    private boolean deleted;

    // A file cannot be created without immediately joining an active folder.
    public File(String name, Folder parent) {
        this.name = Folder.requireName(name);
        this.parent = Objects.requireNonNull(parent, "A file must belong to a folder.");
        parent.registerFile(this);
    }

    public String getName() {
        ensureActive();
        return name;
    }

    public void setName(String name) {
        ensureActive();
        parent.ensureNameAvailable(name, null, this);
        this.name = name;
    }

    public Folder getParent() {
        ensureActive();
        return parent;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        if (!deleted) {
            parent.removeFile(this);
            deleted = true;
        }
    }

    public void print() {
        print(0);
    }

    void print(int depth) {
        ensureActive();
        Folder.printIndent(depth);
        System.out.println(name);
    }

    private void ensureActive() {
        if (deleted) {
            throw new IllegalStateException("This file has been deleted.");
        }
    }
}
