package utils;

import java.util.*;

public class ListUtils {

    /**
     * Generates an ArrayList filled with random integers
     * @param size Size of the random array list
     * @return An ArrayList filled with random integers
     */
    public static List<Integer> generateRandomList(int size) {
        List<Integer> randomList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            randomList.add(generateRandomInteger());
        }
        return randomList;
    }

    /**
     * Partitions a single list into a list of partitions
     * @param list The list to partition
     * @param numPartitions The number of partitions of the original list
     * @return A list containing each partition
     */
    public static List<List<Integer>> partitionList(List<Integer> list, int numPartitions) {
        List<List<Integer>> listOfPartitions = new ArrayList<>(numPartitions);

        int partitionSize = list.size() / numPartitions;
        int remainder = list.size() % numPartitions;
        int index = 0;

        for (int i = 0; i < numPartitions; i++) {
            List<Integer> partition = new LinkedList<>();
            int numbersToAdd = partitionSize;
            if (remainder > 0) {
                numbersToAdd++;
                remainder--;
            }
            int start = index;
            for(int j = 0; j < numbersToAdd; j++) {
                partition.add(list.get(start + j));
                index++;
            }

            listOfPartitions.add(partition);
        }

        return listOfPartitions;
    }

    /**
     * Merges a variable number of sorted lists
     * @param sortedLists A list of sorted lists
     * @return A sorted list of all the input sorted lists
     */
    public static List<Integer> mergeSortedLists(List<List<Integer>> sortedLists) {
        List<Integer> sortedList = new ArrayList<>();
        while (!sortedLists.isEmpty()) {
            int listIndexWithMinVal = 0;
            for (int i = 1; i < sortedLists.size(); i++) {
                if (sortedLists.get(i).get(0) < sortedLists.get(listIndexWithMinVal).get(0)) {
                    listIndexWithMinVal = i;
                }
            }
            sortedList.add(sortedLists.get(listIndexWithMinVal).remove(0));
            if (sortedLists.get(listIndexWithMinVal).isEmpty()) {
                sortedLists.remove(listIndexWithMinVal);
            }
        }
        return sortedList;
    }

    /**
     * Checks if a list is in non-descending order
     * @param list The list to check
     * @return Whether the list is sorted or not
     */
    public static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }

    /**
     * Checks if a value is the minimum value in a list
     * @param list Any list
     * @param minValue The minimum value to check against the list
     * @return Whether the minimum value is indeed the minimum in the list
     */
    public static boolean isMinVal(List<Integer> list, int minValue) {
        return Collections.min(list) == minValue;
    }

    /**
     * Gives a random integers
     * @return A random integer
     */
    private static int generateRandomInteger() {
        return new Random().nextInt();
    }
}
