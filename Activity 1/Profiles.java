import java.util.HashMap;
import java.util.Map;

public class Profiles {
    String name;
    Map<String, Integer> watchHistory = new HashMap<>();

        public Profiles(String name) {
            this.name = name;
        }
public void watchMovie(Movie movie) {
    watchHistory.put(movie.genre, watchHistory.getOrDefault(movie.genre, 0) + movie.duration);
    System.out.println(name + " watched " + movie.title + "(" + movie.genre + ") for " + movie.duration + " mins. ");
}
public String getFavoriteGenre(){
    return watchHistory.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("Unknown");
    }
}