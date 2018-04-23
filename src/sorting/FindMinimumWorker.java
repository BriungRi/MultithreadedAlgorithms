package sorting;

import java.util.Collections;
import java.util.List;

public class FindMinimumWorker extends Thread {
    private final List<Integer> list;
    private int minVal = Integer.MAX_VALUE;

    FindMinimumWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        minVal = Collections.min(list);
    }

    int result() {
        return minVal;
    }
}