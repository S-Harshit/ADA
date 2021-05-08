package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


import java.util.Scanner;

public class FractionalKnapSack {
    private static double maxVal(int[] wt, int[] val,
                                 int finalCap)
    {
        ItemValue[] value = new ItemValue[wt.length];

        for (int i = 0; i < wt.length; i++) {
            value[i] = new ItemValue(wt[i], val[i], i);
        }

        Arrays.sort(value, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }

        });

        double totalValue = 0d;

        for (ItemValue i : value) {

            int curWt = (int)i.wt;
            int curVal = (int)i.val;

            if (finalCap - curWt >= 0) {
                finalCap = finalCap - curWt;
                totalValue += curVal;
            }
            else {
                double fraction = ((double)finalCap / (double)curWt);
                totalValue += (curVal * fraction);
                finalCap = (int)(finalCap - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double)val / (double)wt;
        }
    }

    public static void main(String[] args)
    {
        Random rn = new Random();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        for(int i=0; i<n;i++) {
            weight[i] = rn.nextInt(100);
        }

        int[] value = new int[n];
        for(int i=0; i<n;i++) {
            value[i] = rn.nextInt(1000);
        }

        int finalCap = 500;

        double maxVal = maxVal(weight, value, finalCap);

        System.out.println("Maximum value we can obtain = " + maxVal);
    }
}