package com.montaser.algorithms.sort.merge;

import com.montaser.algorithms.sort.count.CountSort;
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

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Merge sort
 * @since 10-11-2022
 */

public class MergeSortTest {

    private final MergeSort merge = new MergeSort();

    private static BufferedReader reader;

    @BeforeClass
    public static void init() throws Exception {
        URL file = CountSort.class.getResource("/input");
        Path filePath = Paths.get(Objects.requireNonNull(file).toURI());
        reader = Files.newBufferedReader(filePath);
    }

    @AfterClass
    public static void destroy() throws IOException {
        reader.close();
    }

    @Test
    public void test() throws IOException {
        String line;
        while (Objects.nonNull(line = reader.readLine())) {
            int[] before = toIntArray(reader.readLine().split(",\\s"));
            int[] after = toIntArray(reader.readLine().split(",\\s"));

            int max = 0;
            for (int n : before) {
                max = Math.max(max, n);
            }

            merge.sort(before, 0, before.length - 1);

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
