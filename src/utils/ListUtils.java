package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListUtils {
    public static List<Integer> generateRandomList(int size) {
        List<Integer> randomList = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            randomList.add(generateRandomInteger());
        }
        return randomList;
    }

    public static List<List<Integer>> partitionList(List<Integer> list, int numPartitions) {
        List<List<Integer>> listOfPartitions = new ArrayList<>();

        int partitionSize = list.size() / numPartitions;
        int remainder = list.size() % numPartitions;

        for(int i = 0; i < numPartitions; i++) {
            List<Integer> partition = new ArrayList<>();
            for(int j = 0; j < partitionSize; j++) {
                partition.add(list.remove(list.size() - 1));
            }
            if(remainder > 0) {
                partition.add(list.remove(list.size() - 1));
                remainder--;
            }
            listOfPartitions.add(partition);
        }

        return listOfPartitions;
    }




    public static List<Integer> mergeSortedLists(List<List<Integer>> sortedLists) {
        List<Integer> sortedList = new ArrayList<>();
        while(!sortedLists.isEmpty()) {
            int listIndexWithMinVal = 0;
            for(int i = 1; i < sortedLists.size(); i++) {
                if(sortedLists.get(i).get(0) < sortedLists.get(listIndexWithMinVal).get(0)) {
                    listIndexWithMinVal = i;
                }
            }
            sortedList.add(sortedLists.get(listIndexWithMinVal).remove(0));
            if(sortedLists.get(listIndexWithMinVal).isEmpty()) {
                sortedLists.remove(listIndexWithMinVal);
            }
        }
        return sortedList;
    }

    public static boolean isSorted(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }

    private static int generateRandomInteger() {
        return new Random().nextInt();
    }
}
