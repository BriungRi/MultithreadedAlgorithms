import sorting.FindMinimumWorker;
import sorting.MergeSortWorker;
import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class FindMinimum {

    public static int TEST_SIZE = 9000000;

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

    public static void getMinimumElement(int numThreads, int listSize) {
        List<Integer> list = ListUtils.generateRandomList(TEST_SIZE);
        List<List<Integer>> partitions = ListUtils.partitionList(list, numThreads);
        List<FindMinimumWorker> findMinimumElementsList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (List<Integer> partition : partitions) {
            FindMinimumWorker findMinimumWorker = new FindMinimumWorker(partition);
            findMinimumElementsList.add(findMinimumWorker);
            findMinimumWorker.start();
            findMinimumWorker.minVal(partition);
        }

        for(FindMinimumWorker findMinimumWorker : findMinimumElementsList) {
            try {
                findMinimumWorker.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        List<List<Integer>> minLists = new ArrayList<>();
        for(FindMinimumWorker worker : findMinimumElementsList) {
            minLists.add(worker.result());

        }

        long endTime = System.currentTimeMillis();
        System.out.printf("\nList of size %d sorted in %dms", TEST_SIZE, endTime - startTime);
    }

    public void main(String[] args) {

    }
}
