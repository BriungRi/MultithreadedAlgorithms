import utils.ListUtils;

import java.util.List;
import java.util.Scanner;

public class MergeSort {
    public static int TEST_SIZE = 10000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of threads: ");
        int numThreads = input.nextInt();

        List<Integer> randomList = ListUtils.generateRandomList(TEST_SIZE);
    }
}
