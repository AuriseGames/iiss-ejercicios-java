import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DataSorterRandom implements DataSorter {
    public String[] sort(String[] data) {
        Random random = new Random();
        Arrays.sort(data, (a, b) -> random.nextInt(3) - 1);
        return data;
    }
}