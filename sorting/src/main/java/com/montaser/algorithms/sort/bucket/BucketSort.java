package com.montaser.algorithms.sort.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public final class BucketSort {

    @SuppressWarnings("unchecked")
    public void sort(double[] ar, int n) {
        List<Double>[] bucket = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int index = (int) (ar[i] * n);
            bucket[index].add(ar[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(bucket[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            List<Double> list = bucket[i];
            while (!list.isEmpty()) {
                ar[index++] = list.remove(0);
            }
        }
    }
}
