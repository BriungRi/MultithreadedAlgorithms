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

    private static int generateRandomInteger() {
        return new Random().nextInt();
    }
}
