import sorting.MergeSort;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running merge sort tests");
        for(int listSize = 10_000; listSize <= 100_000; listSize += 10_000) {
            //runMergeSortTests(listSize);
            runMinValTests(listSize);
        }
    }

    private static void runMergeSortTests(int listSize) {
        for(int i = 1; i <= 10; i++) {
            MergeSort.mergeSort(i, listSize);
        }
        System.out.println();
    }


    private static void runMinValTests(int listSize) {
        for(int i = 1; i <= 10; i++) {
            FindMinimum.getMinimumElement(i,listSize);
        }
        System.out.println();
    }
}
