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

    private static int generateRandomInteger() {
        return new Random().nextInt();
    }
}
