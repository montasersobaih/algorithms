package com.montaser.algorithms.sort.merge;

import com.montaser.algorithms.sort.count.CountingSort;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class MergeSortTest {

    private MergeSort mergeSort = new MergeSort();

    private static BufferedReader reader;

    @BeforeClass
    public static void init() throws Exception {
        URL file = CountingSort.class.getResource("/input");
        Path filePath = Paths.get(Objects.requireNonNull(file).toURI());
        reader = Files.newBufferedReader(filePath);
    }

    @AfterClass
    public static void destroy() throws IOException {
        reader.close();
    }

    @Test
    public void test() throws IOException {
        String length;
        while (Objects.nonNull(length = reader.readLine())) {
            int[] before = toIntArray(reader.readLine().split(",\\s"));
            int[] after = toIntArray(reader.readLine().split(",\\s"));

            int maxNum = 0;
            for (int n : before) {
                maxNum = Math.max(maxNum, n);
            }

            mergeSort.sort(before, 0, before.length - 1);

            Assert.assertArrayEquals(before, after);
        }
    }

    private int[] toIntArray(String[] ar) {
        int[] n = new int[ar.length];

        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(ar[i]);
        }

        return n;
    }
}
