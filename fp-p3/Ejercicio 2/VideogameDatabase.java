import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VideogameDatabase {

    private List<Videogame> videogames;

    public VideogameDatabase() {
        this.videogames = new ArrayList<>();
    }

    public void addVideogame(Videogame videogame) {
        videogames.add(videogame);
    }

    public List<String> getAllTitles() {
        return videogames.stream()
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAbove(double price) {
        return videogames.stream()
                .filter(v -> v.getPrice() > price)
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithCategory(String category) {
        return videogames.stream()
                .filter(v -> v.getCategory().equalsIgnoreCase(category))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAboveSortedByPriceAsc(double price) {
        return videogames.stream()
                .filter(v -> v.getPrice() > price)
                .sorted((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public List<String> getTitlesWithPriceAboveSortedByPriceDesc(double price) {
        return videogames.stream()
                .filter(v -> v.getPrice() > price)
                .sorted((v1, v2) -> Double.compare(v2.getPrice(), v1.getPrice()))
                .map(Videogame::getTitle)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getVideogameCountByCategory() {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.counting()));
    }

    public Map<String, Double> getPriceSumByCategory() {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory, Collectors.summingDouble(Videogame::getPrice)));
    }

    public Map<String, Double> getPriceSumByCategoryAboveThreshold(double threshold) {
        return videogames.stream()
                .collect(Collectors.groupingBy(Videogame::getCategory,
                        Collectors.summingDouble(Videogame::getPrice)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > threshold)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}