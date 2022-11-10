package com.montaser.algorithms.sort.shell;

/**
 * @author Montaser Sbaih
 * @version 1.0
 * @email montaser.jjs@gmail.com
 * @phone +962-786258874
 * @algorithm Shell sort
 * @since 10-11-2022
 */

public final class ShellSort {

    public void sort(int[] ar, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = ar[i];
                int j;
                for (j = i; j >= gap && ar[j - gap] > temp; j -= gap) {
                    ar[j] = ar[j - gap];
                }
                ar[j] = temp;
            }
        }
    }
}
