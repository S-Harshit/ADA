import java.util.Random;

public class Mergesort {

	private void merge(int[] a, int l, int m, int r) {
		// TODO Auto-generated method stub
		int n1=m-l+1;
		int n2=r-m;

		int L[]= new int[n1];
		int R[]= new int[n2];

		for(int i = 0;i<n1;i++)
			L[i]=a[l+i];
		for(int j = 0;j<n2;j++)
			R[j]=a[m+1+j];

		int i=0,j=0,k=l;

		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				a[k]=L[i];
				i++;
			}
			else {
				a[k]=R[j];
				j++;
			}
			k++;
		}

		while(i<n1) {
			a[k]=L[i];
			i++;
			k++;
		}

		while(j<n2) {
			a[k]=R[j];
			j++;
			k++;
		}
	}

	int[] sort(int a[], int l, int r){

		if(r>l) {

			int m = (l+r)/2;

			sort(a,l,m);
			sort(a,m+1,r);

			merge(a,l,m,r);

		}

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		MergeSort ob = new MergeSort();

		int d[]=new int[100];
		for(int i=0;i<100;i++) {
			d[i]= 2;
		}

		long startTime3 = System.nanoTime();
        ob.sort(d, 0, d.length-1);
        long endTime3 = System.nanoTime();

        long duration3 = (endTime3 - startTime3);
        System.out.println(duration3);

		for(int i:d) {
			System.out.print(i+",");
		}

		System.out.println();

		int a[]=new int[100];
		for(int i=0;i<100;i++) {
			a[i]= rand.nextInt(10000);
		}


		long startTime = System.nanoTime();
        ob.sort(a, 0, a.length-1);
        long endTime = System.nanoTime();



        long duration = (endTime - startTime);
        System.out.println(duration);

		for(int i:a) {
			System.out.print(i+",");
		}

		System.out.println();

		int b[]=new int[100];
		for(int i=0;i<100;i++) {
			b[i]= i+1;
		}

		long startTime1 = System.nanoTime();
        ob.sort(b, 0, b.length-1);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1);
        System.out.println(duration1);

		for(int i:b) {
			System.out.print(i+",");
		}

		System.out.println();

		int c[]=new int[100];
		for(int i=0;i<100;i++) {
			c[i]= 100-i;
		}

		long startTime2 = System.nanoTime();
        ob.sort(c, 0, c.length-1);
        long endTime2 = System.nanoTime();

        long duration2 = (endTime2 - startTime2);
        System.out.println(duration2);

		for(int i:c) {
			System.out.print(i+",");
		}



	}

}
