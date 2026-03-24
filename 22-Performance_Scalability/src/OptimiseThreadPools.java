import java.util.concurrent.*;

public class OptimiseThreadPools {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> five = () -> {
            System.out.println(Thread.currentThread().getName() + " is calculating the square of 5");
            return 5*5;
        };

        Callable<Integer> seven = () -> {
            System.out.println(Thread.currentThread().getName() + " is calculating the square of 7");
            return 7*7;
        };

        Callable<Integer> ten = () -> {
            System.out.println(Thread.currentThread().getName() + " is calculating the square of 10");
            return 10*10;
        };

        Future<Integer> result5 = executor.submit(five);
        Future<Integer> result7 = executor.submit(seven);
        Future<Integer> result10 = executor.submit(ten);

        try {
            System.out.println("Square of 5= " + result5.get());
            System.out.println("Square of 7= " + result7.get());
            System.out.println("Square of 10= " + result10.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }finally {
            executor.shutdown();
        }


    }

}
