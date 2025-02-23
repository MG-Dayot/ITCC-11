import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecursiveFileSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter directory path: ");
        String path = input.nextLine();

        System.out.println("Enter file extension to search: ");
        String extension = input.nextLine();

        FileSystemNode root = new FileSystemNode(path, true);
        FileSystemNode file1 = new FileSystemNode("Activity1.java", false);
        FileSystemNode file2 = new FileSystemNode("Activity2.java", false);
        FileSystemNode subFolder1 = new FileSystemNode("Activities", true);
        FileSystemNode file3 = new FileSystemNode("receipt.txt", false);
        FileSystemNode file4 = new FileSystemNode("Readings.pdf", false);
        FileSystemNode file5 = new FileSystemNode("code snippet.txt", false);
        FileSystemNode subFolder2 = new FileSystemNode("Miscellaneous", true);

        subFolder1.addChild(file1);
        subFolder1.addChild(file2);
        root.addChild(subFolder1);
        subFolder2.addChild(file3);
        root.addChild(file4);
        subFolder2.addChild(file5);
        root.addChild(subFolder2);

        SearchFile search = new SearchFile();

        try(PrintWriter writer = new PrintWriter(new FileWriter("searchResults.txt"))) {
            search.FileFoundListener(filePath -> {
                System.out.println("File found: " + filePath);
                writer.println(filePath);
            });

            System.out.println("Searching...");
            search.search(root, extension, " ");
            System.out.println("\nSearch completed. Results saved to searchResults.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }
}