import java.util.Arrays;

public class DataSorterAsc implements DataSorter {
    public String[] sort(String[] data) {
        Arrays.sort(data, (a, b) -> a.compareTo(b));
        return data;
    }
}