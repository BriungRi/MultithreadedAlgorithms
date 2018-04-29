package sorting;

import utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    /**
     * A control trial of merge sort on a single thread
     * @param listSize The size of list to run the trial on
     */
    public static void mergeSortSingleThread(int listSize) {
        List<Integer> randomList = ListUtils.generateRandomList(listSize);
        long startTime = System.currentTimeMillis();
        Collections.sort(randomList);
        long endTime = System.currentTimeMillis();
        System.out.printf("\nSingle threaded mergeSort run time: %dms", endTime - startTime);
    }

    /**
     * A multithreaded trial of merge sort
     * @param numThreads The number of threads to distribute divide and conquer work on
     * @param listSize The size of the list to sort
     */
    public static void mergeSortMultiThread(int numThreads, int listSize) {
        List<Integer> randomList = ListUtils.generateRandomList(listSize);

        long startTime = System.currentTimeMillis();

        List<List<Integer>> partitions = ListUtils.partitionList(randomList, numThreads);
        List<MergeSortWorker> mergeSortWorkers = new ArrayList<>();
        for (List<Integer> partition : partitions) {
            MergeSortWorker mergeSortWorker = new MergeSortWorker(partition);
            mergeSortWorkers.add(mergeSortWorker);
            mergeSortWorker.start();
        }

        for(MergeSortWorker worker : mergeSortWorkers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<List<Integer>> sortedLists = new ArrayList<>();
        for(MergeSortWorker worker : mergeSortWorkers) {
            sortedLists.add(worker.result());
        }
        List<Integer> sortedList = ListUtils.mergeSortedLists(sortedLists);

        long endTime = System.currentTimeMillis();

        if(ListUtils.isSorted(sortedList)) {
            System.out.printf("\nList of size %d sorted in %dms with %d thread(s)", listSize, endTime - startTime, numThreads);
        } else {
            System.out.println("Something went wrong while sorting");
        }
    }
}
