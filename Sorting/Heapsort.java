package com.company;

import java.util.Random;

public class Heapsort {
    public void sort(int arr[])
    {
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }


    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;


        if (l < n && arr[l] > arr[largest])
            largest = l;


        if (r < n && arr[r] > arr[largest])
            largest = r;


        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest);
        }
    }


    // Driver code
    public static void main(String args[])
    {
        Random rd = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(2000);
        }


        Heapsort ob = new Heapsort();


        long startTime = System.nanoTime();
        ob.sort(arr);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("\nTotal time for Random Array = " + totalTime%1000000);


        for(int ele:arr) {
            System.out.println(ele);
        }
    }
}