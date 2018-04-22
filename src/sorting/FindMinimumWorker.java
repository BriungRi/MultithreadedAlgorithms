package sorting;

import java.util.Collections;
import java.util.List;

public class FindMinimumWorker extends Thread {
    private final List<Integer> list;
    private int minVal = 0;

    public FindMinimumWorker(List<Integer> list) {
        this.list = list; // this may need to be a copy bc shared memory
    }

    @Override
    public void run() {
        minVal(list);
    }

    public int result() {
        return minVal;
    }

    private int minVal(List<Integer> neck) {
        int start = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = start; i < list.size(); i++) {
            int val = list.get(i);
            if (val < min) {
                min = val;
                minVal = min;
            }
            return min;
        }
        return 0;
    }
}