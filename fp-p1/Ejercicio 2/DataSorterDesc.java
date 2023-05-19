import java.util.Arrays;

public class DataSorterDesc implements DataSorter {
    public String[] sort(String[] data) {
        Arrays.sort(data, (a, b) -> b.compareTo(a));
        return data;
    }
}