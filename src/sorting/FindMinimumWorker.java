package sorting;

import java.util.List;

public class FindMinimumWorker extends Thread {
    private final List<Integer> list;
    private Integer minVal = null;

    FindMinimumWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer value : list) {
            if (minVal == null || value < minVal) {
                minVal = value;
            }
        }
    }

    int result() {
        return minVal;
    }
}