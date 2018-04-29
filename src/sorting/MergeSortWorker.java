package sorting;

import java.util.Collections;
import java.util.List;

public class MergeSortWorker extends Thread {
    private final List<Integer> list;

    MergeSortWorker(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Collections.sort(list);
    }

    List<Integer> result() {
        return list;
    }
}
