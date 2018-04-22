package sorting;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class FindMinimum {
    public static void getMinimumElement(int numThreads, int listSize) {
        List<Integer> list = ListUtils.generateRandomList(listSize);

        long startTime = System.currentTimeMillis();
        List<List<Integer>> partitions = ListUtils.partitionList(list, numThreads);
        List<FindMinimumWorker> workers = new ArrayList<>();
        for (List<Integer> partition : partitions) {
            FindMinimumWorker findMinimumWorker = new FindMinimumWorker(partition);
            workers.add(findMinimumWorker);
            findMinimumWorker.start();
        }

        for(FindMinimumWorker findMinimumWorker : workers) {
            try {
                findMinimumWorker.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(FindMinimumWorker worker : workers) {
            if(worker.result() < minValue)
                minValue = worker.result();
        }
        long endTime = System.currentTimeMillis();

        if(ListUtils.isMinVal(list, minValue))
            System.out.printf("\nMin found in list of size %d in %dms with %d thread(s)", listSize, endTime - startTime, numThreads);
    }
}
