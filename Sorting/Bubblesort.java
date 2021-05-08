public class Bubblesort {

	int[] Insert(int a[]) {

		int temp;
		int i,j;

		for(i=0;i<a.length;i++) {
			for(j=1; j<a.length-i ;j++) {
				if(a[j-1]>a[j]) {
					temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
				}
			}
		}

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {2,5,1,7,3,6};

		BubbleSort sort = new BubbleSort();

		sort.Insert(a);

		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}
