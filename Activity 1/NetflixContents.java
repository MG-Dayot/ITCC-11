import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface NetflixContents {
    static List<Movie> movies = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        movies.add(new Movie("Lift", "Crime", 106));
        movies.add(new Movie("It's What's Inside", "Mystery", 104));
        movies.add(new Movie("The Garfield Movie", "Comedy", 90));
        movies.add(new Movie("Glass Onion", "Mystery", 141));
        movies.add(new Movie("Unlocked", "Mystery", 117));

        System.out.print("\nEnter your name: ");
          Profiles user = new Profiles(sc.nextLine());
          
          while (true) {
              System.out.println("\nAvailable Movies:");
              for (int i = 0; i < movies.size(); i++) {
                  System.out.println((i + 1) + ". " + movies.get(i).title + " (" + movies.get(i).genre + ")");
              }
              
              System.out.print("Enter the movie number to watch (0 to exit): ");
              int choice = sc.nextInt();
              if (choice == 0) break;
              
              if (choice > 0 && choice <= movies.size()) {
                  user.watchMovie(movies.get(choice - 1));
              } else {
                  System.out.println("Invalid choice!");
              }
          }
          
          // Recommend a movie based on most-watched genre
          String favGenre = user.getFavoriteGenre();
          System.out.println("\nBased on your watch history, we recommend:");
          movies.stream().filter(m -> m.genre.equals(favGenre)).findFirst().ifPresent(m ->
                  System.out.println(m.title + " (" + m.genre + ")"));
    }

}