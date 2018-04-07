package utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListUtilsTest {
    @Test
    public void generateRandomList() throws Exception {
        int size = 1000;
        List<Integer> randomList = ListUtils.generateRandomList(size);
        assertEquals(size, randomList.size());
    }

}