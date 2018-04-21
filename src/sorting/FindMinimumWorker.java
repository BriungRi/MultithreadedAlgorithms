package sorting;

import java.util.Collections;
import java.util.List;

public class FindMinimumWorker extends Thread {
    private final List<Integer> list;

    public FindMinimumWorker(List<Integer> list) {
        this.list = list; // this may need to be a copy bc shared memory
    }


    @Override
    public int result() {
        return list.get(0);
    }

    public static int minVal(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < list.size(); i++) {
            int val = list.get(i);
            if (val < min) {
                min = val;
            }
            return min;
        }
        return 0;
    }
}