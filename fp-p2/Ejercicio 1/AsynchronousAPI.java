import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynchronousAPI {

    public static Future<Integer> additionAsync(List<Integer> elements) throws InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            int sum = 0;
            for (Integer element : elements) {
                System.out.println("Adding " + element);
                try {
                    Thread.sleep(5000); // Retardo de 5 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += element;
            }
            completableFuture.complete(sum);
        });

        return completableFuture;
    }
}