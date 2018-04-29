package sorting;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinimum {

    /**
     * A control trial of find min. Uses built in Collections.min() to find a minimum
     * @param listSize Size of list to find min in
     */
    public static void findMinSingleThread(int listSize) {
        List<Integer> list = ListUtils.generateRandomList(listSize);
        long startTime = System.currentTimeMillis();
        Collections.min(list);
        long endTime = System.currentTimeMillis();
        System.out.printf("\nSingle threaded findMin run time: %dms", endTime - startTime);
    }

    /**
     * A trial of the find min algorithm
     * @param numThreads The number of threads to distribute divide and conquer work on
     * @param listSize Size of list to find min in
     */
    public static void findMinMultiThread(int numThreads, int listSize) {
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
            minValue = Math.min(minValue, worker.result());
        }

        long endTime = System.currentTimeMillis();

        if(ListUtils.isMinVal(list, minValue)) {
            System.out.printf("\nMin found in list of size %d in %dms with %d thread(s)", listSize, endTime - startTime, numThreads);
        } else {
            System.out.println("Something went wrong while finding minimum");
        }
    }
}
