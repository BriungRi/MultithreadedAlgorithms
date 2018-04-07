package utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListUtilsTest {
    @Test
    public void generateRandomList() throws Exception {
        int size = 1000;
        List<Integer> randomList = ListUtils.generateRandomList(size);
        assertEquals(size, randomList.size());
    }

    @Test
    public void partitionList() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        List<List<Integer>> partitions = ListUtils.partitionList(list, 3);
        assertEquals(3, partitions.get(0).size());
        assertEquals(3, partitions.get(1).size());
        assertEquals(2, partitions.get(2).size());
    }

}