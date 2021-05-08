package com.company;

import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;

// Harshit 19csu411

public class Prim {

    public static int[] prim(int[][] arr) {

        int[] tv = { 4, 0, 0, 0, 0 };

        int tvc = 0;

        int v = 0;

        int v1 = 0;

        for (int m = 1; m < 5; m++) {
            int min = 100;
            for (int j = 0; j < tvc; j++) {
                for (int i = 0; i < 5; i++) {
                    if (min > arr[tv[j]][i]) {
                        v = i;
                        v1 = tv[j];
                        min = arr[tv[j]][i];
                    }
                }
            }
            tvc++;
            tv[tvc] = v;
            arr[v][v1] = arr[v1][v] = 100;
        }

        return tv;
    }

    public static void main(String[] args) {

        int[][] graph = { { 100, 3, 8, 11, 101 }, { 8, 100, 4, 6, 7 }, { 7, 9, 2, 100, 4 }, { 100, 12, 32, 100, 15 },
                { 100, 69, 100, 16,13} };

        int arr[] = prim(graph);

        for (int i : arr) {
            System.out.println(i);
        }

    }

}
//
//output:
//4
//0
//4
//1
//2

