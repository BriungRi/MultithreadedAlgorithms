import sorting.MergeSortWorker;
import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static final int TEST_SIZE = 200000;

    public static void main(String[] args) throws InterruptedException {
        int numThreads = Integer.parseInt(args[0]);
        List<Integer> randomList = ListUtils.generateRandomList(TEST_SIZE);

        long startTime = System.currentTimeMillis();

        List<List<Integer>> partitions = ListUtils.partitionList(randomList, numThreads);
        List<MergeSortWorker> mergeSortWorkers = new ArrayList<>();
        for(int i = 0; i < partitions.size(); i++) {
            MergeSortWorker mergeSortWorker = new MergeSortWorker(partitions.get(i));
            mergeSortWorkers.add(mergeSortWorker);
            mergeSortWorker.start();
        }

        for(MergeSortWorker worker : mergeSortWorkers)
            worker.join();

        List<List<Integer>> sortedLists = new ArrayList<>();
        for(MergeSortWorker worker : mergeSortWorkers) {
            sortedLists.add(worker.result());
        }
        List<Integer> sortedList = ListUtils.mergeSortedLists(sortedLists);

        if(ListUtils.isSorted(sortedList)) {
            long endTime = System.currentTimeMillis();
            System.out.printf("\nList of size %d sorted in %dms", TEST_SIZE, endTime - startTime);
        }
    }
}
