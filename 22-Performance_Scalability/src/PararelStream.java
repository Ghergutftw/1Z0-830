import java.util.List;

public class PararelStream {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(integer -> {
            System.out.println(Thread.currentThread().getName() + ": is doing the sqrt of " +  integer + " which is " + Math.sqrt(integer));
        });
        //ForkJoinPool.commonPool-worker-7: is doing the sqrt of 7 which is 2.6457513110645907
        //ForkJoinPool.commonPool-worker-7: is doing the sqrt of 9 which is 3.0
        //ForkJoinPool.commonPool-worker-4: is doing the sqrt of 5 which is 2.23606797749979
        //ForkJoinPool.commonPool-worker-1: is doing the sqrt of 3 which is 1.7320508075688772
        //ForkJoinPool.commonPool-worker-5: is doing the sqrt of 4 which is 2.0
        //ForkJoinPool.commonPool-worker-3: is doing the sqrt of 2 which is 1.4142135623730951
        //main: is doing the sqrt of 6 which is 2.449489742783178
        //ForkJoinPool.commonPool-worker-2: is doing the sqrt of 8 which is 2.8284271247461903
        //ForkJoinPool.commonPool-worker-6: is doing the sqrt of 1 which is 1.0
    }
}
