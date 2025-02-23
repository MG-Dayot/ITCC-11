import java.util.ArrayList;
import java.util.List;

public class FileSystemNode {
    String name;
    boolean isDirectroy;
    List<FileSystemNode> children;

    FileSystemNode(String name, boolean isDirectroy) {
        this.name = name;
        this.isDirectroy = isDirectroy;
        this.children = new ArrayList<>();
    }

    void addChild(FileSystemNode child) {
        if(this.isDirectroy) {
            this.children.add(child);
        }
    }
}
