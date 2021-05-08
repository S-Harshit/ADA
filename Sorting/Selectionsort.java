public class Selectionsort {

	int[] Select(int a[]) {

		int temp;
		int i,j;

		for(i=0;i<a.length;i++) {
			int min = i;
			for(j=i+1;j<a.length;j++) {
				if(a[j]<a[min]) {
					min = j;
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {2,5,1,7,3,6};

		SelectionSort sort = new SelectionSort();

		sort.Select(a);

		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}
