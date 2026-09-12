package problem5;

public class CompositionDriver {
    public static void main(String[] args) {
        Folder phpDemo1 = new Folder("php_demo1");
        Folder sourceFiles = phpDemo1.addFolder("Source Files");

        sourceFiles.addFolder(".phalcon");
        Folder app = sourceFiles.addFolder("app");
        app.addFolder("config");
        app.addFolder("controllers");
        app.addFolder("library");
        app.addFolder("migrations");
        app.addFolder("models");
        app.addFolder("views");
        sourceFiles.addFolder("cache");
        sourceFiles.addFolder("public");

        // These three files are siblings of public in the supplied image.
        sourceFiles.addFile(".htaccess");
        sourceFiles.addFile(".htrouter.php");
        sourceFiles.addFile("index.html");

        // Represent the two additional visible project nodes as empty folders.
        phpDemo1.addFolder("Include Path");
        phpDemo1.addFolder("Remote Files");

        System.out.println("Step 1: Original php_demo1 structure");
        phpDemo1.print();

        sourceFiles.deleteFolder("app");
        System.out.println("\nStep 2: After deleting app");
        phpDemo1.print();

        sourceFiles.deleteFolder("public");
        System.out.println("\nStep 3: After deleting public");
        phpDemo1.print();
    }
}
