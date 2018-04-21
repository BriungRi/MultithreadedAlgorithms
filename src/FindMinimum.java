import sorting.FindMinimumWorker;
import sorting.MergeSortWorker;
import utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinimum {

    public static int TEST_SIZE = 9000000;

    public static void getMinimumElement(int numThreads, int listSize) {
        List<Integer> list = ListUtils.generateRandomList(listSize);
        List<List<Integer>> partitions = ListUtils.partitionList(list, numThreads);
        List<FindMinimumWorker> findMinimumElementsList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (List<Integer> partition : partitions) {
            FindMinimumWorker findMinimumWorker = new FindMinimumWorker(partition);
            findMinimumElementsList.add(findMinimumWorker);
            findMinimumWorker.start();
        }

        for(FindMinimumWorker findMinimumWorker : findMinimumElementsList) {
            try {
                findMinimumWorker.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        List<Integer> minLists = new ArrayList<>();
        for(FindMinimumWorker worker : findMinimumElementsList) {
            minLists.add(worker.result());
            Collections.min(minLists);
        }

        long endTime = System.currentTimeMillis();
        System.out.printf("\nList of size %d sorted in %dms", listSize, endTime - startTime);
    }
}
