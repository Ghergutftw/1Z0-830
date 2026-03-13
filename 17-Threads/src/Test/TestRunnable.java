package Test;
// pass by value
//public class TestRunnable implements Runnable {
//    Integer nr;
//    int value;
//    TestRunnable(Integer nr, int value){
//        this.nr = nr;
//        this.value = value;
//    }
//    @Override
//    public void run() {
//        System.out.println("Runnable " + nr + " din " + Thread.currentThread().getName() + ": " + value);
//    }
//}

//pass by reference
public class TestRunnable implements Runnable {
    SharedData data; // Aceasta este o referință (telecomandă) către obiectul din Heap

    TestRunnable(SharedData data) {
        this.data = data; // Copiem ADRESA de memorie, nu valoarea 5
    }

    @Override
    public void run() {
        // Modificăm direct obiectul de la adresa primită
        data.value = data.value + 1;
        System.out.println(Thread.currentThread().getName() + " a modificat la: " + data.value);
    }
}
