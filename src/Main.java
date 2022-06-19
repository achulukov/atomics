import store.Store;

import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> sales1 = new ArrayList<>();
        ArrayList<Integer> sales2 = new ArrayList<>();
        ArrayList<Integer> sales3 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int random1 = (int) (Math.random() * 1000);
            sales1.add(random1);
            int random2 = (int) (Math.random() * 1000);
            sales1.add(random2);
            int random3 = (int) (Math.random() * 1000);
            sales1.add(random3);
        }

        LongAdder longAdder = new LongAdder();

        Store store = new Store();

        Thread thread1 = new Thread(null, () -> store.count(sales1, longAdder));
        Thread thread2 = new Thread(null, () -> store.count(sales2, longAdder));
        Thread thread3 = new Thread(null, () -> store.count(sales3, longAdder));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(longAdder.sum());

    }
}
