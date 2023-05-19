import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> elements2 = Arrays.asList(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        CompletableFuture<Integer> additionFuture = AsynchronousAPI.additionAsync(elements);
        CompletableFuture<Integer> multiplicationFuture = AsynchronousAPI.multiplicationAsync(elements2);

        CompletableFuture<Void> completableFuture = additionFuture.thenCombine(multiplicationFuture, (additionResult, multiplicationResult) -> {
            System.out.println("The result is " + additionResult);
            System.out.println("The multiplication result is " + multiplicationResult);
            return null;
        });

        completableFuture.get();
    }
}