package sorting;

import sorting.MergeSortWorker;
import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void mergeSort(int numThreads, int listSize) {
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
