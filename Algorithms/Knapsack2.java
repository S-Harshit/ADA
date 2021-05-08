package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class  Knapsack2{
	private static double maxVal(int[] wt, int[] val, int finalCap) {
		PerItemVal[] value = new PerItemVal[wt.length];

		for (int i = 0; i < wt.length; i++) {
			value[i] = new PerItemVal(wt[i], val[i], i);
		}

		Arrays.sort(value, new Comparator<PerItemVal>() {
			@Override
			public int compare(PerItemVal o1, PerItemVal o2) {
				return o2.cost.compareTo(o1.cost);
			}
		});

		double totalValue = 0d;

		for (PerItemVal i : value) {

			int curWt = (int) i.wt;
			int curVal = (int) i.val;

			if (finalCap - curWt >= 0) {
				finalCap = finalCap - curWt;
				totalValue += curVal;
			} else {
				double fraction = ((double) finalCap / (double) curWt);
				totalValue += (curVal * fraction);
				finalCap = (int) (finalCap - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}

	static class PerItemVal {
		Double cost;
		double wt, val, ind;

		public PerItemVal(int wt, int val, int ind) {
			this.wt = wt;
			this.val = val;
			this.ind = ind;
			cost = (double) val / (double) wt;
		}
	}

	public static void main(String[] args) {
		Random rn = new Random();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of items: ");
		int n = sc.nextInt();

		int[] weight = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = rn.nextInt(100);
		}

		int[] value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = rn.nextInt(1000);
		}

		System.out.println("Enter capacity: ");
		int c = sc.nextInt();

		int finalCap = c;

		double maxVal = maxVal(weight, value, finalCap);

		System.out.println("Maximum value we can obtain = " + maxVal);

		sc.close();
	}
}
