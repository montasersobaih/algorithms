package com.montaser.algorithms.sort.count;

public final class CountingSort {

    public void sort(int[] ar, int maxNum) {
        int[] output = new int[ar.length];
        int[] count = new int[maxNum + 1];

        for (int i = 0; i < ar.length; i++) {
            count[ar[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < ar.length; i++) {
            count[ar[i]]--;
            output[count[ar[i]]] = ar[i];
        }

        for (int i = 0; i < ar.length; i++) {
            ar[i] = output[i];
        }
    }
}
