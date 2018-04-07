package sorting;

import java.util.Collections;
import java.util.List;

public class MergeSortWorker extends Thread{
    private final List<Integer> list;

    public MergeSortWorker(List<Integer> list) {
        this.list = list; // this may need to be a copy bc shared memory
    }

    @Override
    public void run() {
        Collections.sort(list);
    }

    public List<Integer> result() {
        return list;
    }
}
