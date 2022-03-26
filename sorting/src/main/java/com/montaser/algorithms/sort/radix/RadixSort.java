package com.montaser.algorithms.sort.radix;

public class RadixSort {

    public void sort(int[] ar, int maxNum) {
        for (int exp = 1; maxNum / exp > 0; exp *= 10) {
            countSort(ar, exp);
        }
    }

    private void countSort(int[] ar, int exp) {
        int[] output = new int[ar.length];
        int[] count = new int[10];

        for (int i = 0; i < ar.length; i++) {
            count[(ar[i] / exp) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ar.length - 1; i >= 0; i--) {
            count[(ar[i] / exp) % 10]--;
            output[count[(ar[i] / exp) % 10]] = ar[i];
        }

        for (int i = 0; i < ar.length; i++) {
            ar[i] = output[i];
        }
    }
}
