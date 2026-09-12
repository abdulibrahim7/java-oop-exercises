package problem5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A folder that owns its files and subfolders in a simulated file system. */
public class Folder {
    private String name;
    private Folder parent;
    private final List<Folder> subFolders = new ArrayList<>();
    private final List<File> files = new ArrayList<>();
    private boolean deleted;

    public Folder(String name) {
        this(name, null);
    }

    private Folder(String name, Folder parent) {
        this.name = requireName(name);
        this.parent = parent;
    }

    public String getName() {
        ensureActive();
        return name;
    }

    public void setName(String name) {
        ensureActive();
        requireName(name);
        if (parent != null) {
            parent.ensureNameAvailable(name, this, null);
        }
        this.name = name;
    }

    public Folder getParent() {
        ensureActive();
        return parent;
    }

    public List<Folder> getSubFolders() {
        ensureActive();
        return Collections.unmodifiableList(new ArrayList<>(subFolders));
    }

    public List<File> getFiles() {
        ensureActive();
        return Collections.unmodifiableList(new ArrayList<>(files));
    }

    public boolean isDeleted() {
        return deleted;
    }

    // Children are created inside their owner; existing children cannot be shared.
    public Folder addFolder(String name) {
        ensureNameAvailable(name, null, null);
        Folder child = new Folder(name, this);
        subFolders.add(child);
        return child;
    }

    public File addFile(String name) {
        ensureActive();
        return new File(name, this);
    }

    void registerFile(File file) {
        ensureNameAvailable(file.getName(), null, null);
        if (file.getParent() != this) {
            throw new IllegalArgumentException("The file must belong to this folder.");
        }
        files.add(file);
    }

    void removeFile(File file) {
        ensureActive();
        files.remove(file);
    }

    public boolean deleteFolder(String name) {
        ensureActive();
        for (Folder child : new ArrayList<>(subFolders)) {
            if (child.getName().equals(name)) {
                child.delete();
                return true;
            }
        }
        return false;
    }

    public boolean deleteFile(String name) {
        ensureActive();
        for (File file : new ArrayList<>(files)) {
            if (file.getName().equals(name)) {
                file.delete();
                return true;
            }
        }
        return false;
    }

    public void delete() {
        if (deleted) {
            return;
        }

        // Delete every descendant before removing this folder from its parent.
        for (Folder child : new ArrayList<>(subFolders)) {
            child.delete();
        }
        for (File file : new ArrayList<>(files)) {
            file.delete();
        }
        if (parent != null) {
            parent.subFolders.remove(this);
            parent = null;
        }
        deleted = true;
    }

    public void print() {
        print(0);
    }

    private void print(int depth) {
        ensureActive();
        printIndent(depth);
        System.out.println(name + "/");
        for (Folder child : subFolders) {
            child.print(depth + 1);
        }
        for (File file : files) {
            file.print(depth + 1);
        }
    }

    static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
    }

    static String requireName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name is required.");
        }
        return name;
    }

    void ensureNameAvailable(String name, Folder ignoredFolder, File ignoredFile) {
        ensureActive();
        requireName(name);
        for (Folder child : subFolders) {
            if (child != ignoredFolder && child.getName().equals(name)) {
                throw new IllegalArgumentException("That name already exists in this folder.");
            }
        }
        for (File file : files) {
            if (file != ignoredFile && file.getName().equals(name)) {
                throw new IllegalArgumentException("That name already exists in this folder.");
            }
        }
    }

    void ensureActive() {
        if (deleted) {
            throw new IllegalStateException("This folder has been deleted.");
        }
    }
}
