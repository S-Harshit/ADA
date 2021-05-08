package com.company;

import java.util.Random;

public class Quicksort {

    static int count;
    int PARTION(int arr[],int p, int r) {
        int x = arr[r];
        int i=p-1;
        int temp;
        for(int j=p;j<=r-1;j++) {
            if (arr[j]<=x) {
                i = i + 1;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        return i+1;
    }


    void sort(int arr[],int p,int r) {
        if(p<r) {
            int q = PARTION(arr,p,r);
            count++;
            sort(arr,p,q-1);
            count++;
            sort(arr,q+1,r);

        }
    }

    int getCount() {
        return count;
    }

}

class qmain {
    public static void main(String[] args) {

        Quicksort sort = new Quicksort();

        //Random Array
        Random rd = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(3000);
        }

//        System.out.println("Before Sort:");
//        for (int ele : arr) {
//            System.out.print(ele+"\t");
//        }

        //random 1000 number
        long startTime = System.nanoTime();
        sort.sort(arr,0,arr.length-1);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("\nTotal time for Random Array = " + totalTime%1000000);
        System.out.println("No of Rec Calls:" + sort.getCount());
        sort.count = 0;

        //Ascending order
        int b[]=new int[1000];
        for(int i=0;i<1000;i++) {
            b[i]= i+1;
        }

        startTime = System.nanoTime();
        sort.sort(b, 0, b.length-1);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("\nTotal time for Ascending Order = " + totalTime%1000000);
        System.out.println("No of Rec Calls:" + sort.getCount());
        sort.count = 0;

        //Descending order
        int c[]=new int[1000];
        for(int i=0;i<1000;i++) {
            c[i]= 1000-i;
        }

        startTime = System.nanoTime();
        sort.sort(c, 0, c.length-1);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("\nTotal time Descending order = " + totalTime%1000000);
        System.out.println("No of Rec Calls:" + sort.getCount());
        sort.count = 0;
        //

        //Same Elements
        int d[]=new int[1000];
        for(int i=0;i<1000;i++) {
            d[i]= 2;
        }
        startTime = System.nanoTime();
        sort.sort(d, 0, d.length-1);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("\nTotal time same elements = " + totalTime%1000000);
        System.out.println("No of Rec Calls:" + sort.getCount());
        sort.count = 0;




        System.out.println("\nAfter sort:");
        for (int ele : arr) {
            System.out.print(ele+"\t");
        }
    }
}
