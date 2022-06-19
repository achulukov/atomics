package store;

import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;

public class Store extends Thread{

    public void count(ArrayList<Integer> sales, LongAdder longAdder) {
        int sum = 0;
        for (int sale : sales) {
            sum += sale;
        }
        longAdder.add(sum);
    }
}
