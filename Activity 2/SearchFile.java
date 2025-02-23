import java.io.*;
import java.util.*;

public class SearchFile {
    private FileFoundListener listener;

    void FileFoundListener(FileFoundListener listener) {
        this.listener = listener;
    }

    void search(FileSystemNode node, String extension, String path) {
        if (!node.isDirectroy && node.name.endsWith(extension)) {
            if (listener != null) {
                listener.onFileFound(path + node.name);
            }
        } else if (node.isDirectroy) {
            for (FileSystemNode child : node.children) {
                search(child, extension, path + node.name + "/")
            }
        }
    }
}
