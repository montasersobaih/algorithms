package com.montaser.algorithms.sort.bucket;

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
 * @algorithm Bucket sort
 * @description Bucket sort is mainly useful when input is uniformly distributed over a range.
 * Bucket sort sorts a large set of floating point numbers which are in range from 0.0 to 1.0 and are
 * uniformly distributed across the range.
 * @since 10-11-2022
 */

public class BucketSortTest {

    private final BucketSort bucket = new BucketSort();

    private static BufferedReader reader;

    @BeforeClass
    public static void init() throws Exception {
        URL file = BucketSortTest.class.getResource("/input");
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
            int length = Integer.parseInt(line);
            double[] before = toDoubleArray(reader.readLine().split(",\\s"));
            double[] after = toDoubleArray(reader.readLine().split(",\\s"));

            bucket.sort(before, length);

            Assert.assertArrayEquals(before, after, 0.0);
        }
    }

    private double[] toDoubleArray(String[] ar) {
        double[] n = new double[ar.length];

        double max = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Double.parseDouble(ar[i]);
            if (n[i] > max) {
                max = n[i];
            }
        }

        int divisor = 10;
        while (max / divisor > 1) {
            divisor *= 10;
        }

        for (int i = 0; i < n.length; i++) {
            n[i] = n[i] / divisor;
        }

        return n;
    }
}
