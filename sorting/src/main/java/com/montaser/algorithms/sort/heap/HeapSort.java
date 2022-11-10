package com.montaser.algorithms.sort.heap;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Heap sort
 * @since 10-11-2022
 */

public final class HeapSort {

    public void sort(int[] ar) {
        int n = ar.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(ar, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int swap = ar[0];
            ar[0] = ar[i];
            ar[i] = swap;

            heap(ar, i, 0);
        }
    }

    public void heap(int[] ar, int n, int i) {
        int root = i, left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && ar[left] > ar[root]) {
            root = left;
        }

        if (right < n && ar[right] > ar[root]) {
            root = right;
        }

        if (root != i) {
            int swap = ar[i];
            ar[i] = ar[root];
            ar[root] = swap;

            heap(ar, n, root);
        }
    }
}
