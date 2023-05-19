import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        String [] data = {"H", "S", "I", "V", "E", "W", "M", "P", "L",  "C", "N", "K",
                 "O", "A", "Q", "R", "J", "D", "G", "T", "U", "X", "B", "Y", "Z", "F"};
        System.out.println("data = " + Arrays.toString(data));
        DataSorter dataSorter = new DataSorterDesc();
        dataSorter.sort(data);
        System.out.println("data (desc) = " + Arrays.toString(data));
        dataSorter = new DataSorterAsc();
        dataSorter.sort(data);
        System.out.println("data (asc) = " + Arrays.toString(data));
        dataSorter = new DataSorterRandom();
        dataSorter.sort(data);
        System.out.println("data (random) = " + Arrays.toString(data));
    }
}