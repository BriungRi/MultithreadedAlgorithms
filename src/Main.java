import sorting.FindMinimum;
import sorting.MergeSort;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running merge sort tests");
        for(int listSize = 1_000_000; listSize <= 10_000_000; listSize += 1_000_000) {
            runMergeSortTests(listSize);
        }
        System.out.println("Running find min tests");
        for(int listSize = 1_000_000; listSize <= 10_000_000; listSize += 1_000_000) {
            runMinValTests(listSize);
        }
    }

    /**
     * Runs merge sort trials on 1..10 threads
     * @param listSize The list size to sort
     */
    private static void runMergeSortTests(int listSize) {
        MergeSort.mergeSortSingleThread(listSize);
        for(int i = 2; i <= 10; i++) {
            MergeSort.mergeSortMultiThread(i, listSize);
            System.gc();
        }
        System.out.println();
    }

    /**
     * Runs find min trials on 1..10 threads
     * @param listSize The list size to find min in
     */
    private static void runMinValTests(int listSize) {
        FindMinimum.findMinSingleThread(listSize);
        for(int i = 2; i <= 10; i++) {
            FindMinimum.findMinMultiThread(i,listSize);
            System.gc();
        }
        System.out.println();
    }
}
