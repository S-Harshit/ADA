
import java.util.Random;

public class Quicksortquestion {

	private static int count = 0;

	public int partition(int a[],int l,int r){
		int x=a[r];
		int i = l-1;
		int j=0;
		int temp=0;
		for(j=l;j<r;j++) {
			if(a[j]<x) {
				i++;
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[i+1];
		a[i+1]=a[r];
		a[r]=temp;
		return i+1;
	}

	public static int getCount() {
		return count;
	}

	public void sort(int a[],int l,int r) {
		int p=0;
		if(l<r) {
			p = partition(a,l,r);

			count=count+1;
			sort(a,l,p-1);
			count=count+1;
			sort(a,p+1,r);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuickSortQ1 sort=new QuickSortQ1();
		Random r = new Random();

		System.out.println("For random: ");
		int a[] = new int[1000];
		for(int i=0;i<1000;i++) {
			a[i]=r.nextInt(5000);
		}

		long startTime = System.nanoTime();
		sort.sort(a, 0, a.length-1);
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
        System.out.println(duration);
//        System.out.println();
//		for(int i:a) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		System.out.println(sort.getCount());
		count=0;


		System.out.println("For ascending: ");
		int b[] = new int[1000];
		for(int i=0;i<1000;i++) {
			b[i]=i;
		}

		long startTime1 = System.nanoTime();
		sort.sort(b, 0, b.length-1);
		long endTime1 = System.nanoTime();

		long duration1 = (endTime1 - startTime1);
        System.out.println(duration1);
//        System.out.println();
//		for(int i:b) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		System.out.println(sort.getCount());
		count=0;

		System.out.println("For descending: ");
		int c[] = new int[1000];
		for(int i=0;i<1000;i++) {
			c[i]=i;
		}

		long startTime2 = System.nanoTime();
		sort.sort(c, 0, c.length-1);
		long endTime2 = System.nanoTime();

		long duration2 = (endTime2 - startTime2);
        System.out.println(duration2);
//        System.out.println();
//		for(int i:c) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		System.out.println(sort.getCount());
		count=0;

		System.out.println("For same: ");
		int d[] = new int[1000];
		for(int i=0;i<1000;i++) {
			d[i]=5;
		}

		long startTime3 = System.nanoTime();
		sort.sort(d, 0, d.length-1);
		long endTime3 = System.nanoTime();

		long duration3 = (endTime3 - startTime3);
        System.out.println(duration3);
//        System.out.println();
//		for(int i:d) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
		System.out.println(sort.getCount());
		count=0;

	}

}
