import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Future<Integer> completableFuture = AsynchronousAPI.additionAsync(elements);
        Integer result = completableFuture.get();
        System.out.println("The result is " + result);
    }
}