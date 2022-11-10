package com.montaser.algorithms.sort.radix;

import com.montaser.algorithms.sort.count.CountSort;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Radix sort
 * @since 10-11-2022
 */

public final class RadixSort {

    private final CountSort count = new CountSort();

    public void sort(int[] ar, int maxNum) {
        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            count.sort(ar, exp);
        }
    }
}
