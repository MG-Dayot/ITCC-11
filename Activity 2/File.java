public class File {
    String name;
    boolean isDirectroy;
    List<File> children;

    File(String name, boolean isDirectroy) {
        this.name = name;
        this.isDirectroy = isDirectroy;
        this.children = new ArrayList<>();
    }
    
}
