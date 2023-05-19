import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class AsynchronousAPI {

    public static CompletableFuture<Integer> additionAsync(List<Integer> elements) throws InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            int sum = 0;
            for (Integer element : elements) {
                System.out.println("Adding " + element);
                try {
                    Thread.sleep(2000); // Retardo de 2 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum += element;
            }
            completableFuture.complete(sum);
        });

        return completableFuture;
    }

    public static CompletableFuture<Integer> multiplicationAsync(List<Integer> elements) throws InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            int product = 1;
            for (Integer element : elements) {
                System.out.println("Multiplying " + element);
                try {
                    Thread.sleep(3000); // Retardo de 3 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                product *= element;
            }
            completableFuture.complete(product);
        });

        return completableFuture;
    }

}