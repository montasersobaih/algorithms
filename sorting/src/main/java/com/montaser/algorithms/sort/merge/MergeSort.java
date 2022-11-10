package com.montaser.algorithms.sort.merge;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Merge sort
 * @since 10-11-2022
 */

public final class MergeSort {

    public void sort(int[] ar, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(ar, low, mid);
            sort(ar, mid + 1, high);
            merge(ar, low, mid + 1, high);
        }
    }

    private void merge(int[] ar, int low, int mid, int high) {
        int[] helper = new int[ar.length];

        for (int i = low; i <= high; i++) {
            helper[i] = ar[i];
        }

        int i = low, j = mid, k = low;
        while (i < mid && j <= high) {
            if (helper[i] <= helper[j]) {
                ar[k] = helper[i++];
            } else {
                ar[k] = helper[j++];
            }
            k++;
        }

        while (i < mid) {
            ar[k++] = helper[i++];
        }

        while (j <= high) {
            ar[k++] = helper[j++];
        }
    }
}