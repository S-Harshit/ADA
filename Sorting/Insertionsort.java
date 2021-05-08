
public class Insertionsort {

	int[] Insert(int a[]) {

		int key;
		int i,j;

		for(i=1;i<a.length;i++) {
			key=a[i];
			for(j=i-1; j>-1 && a[j]>key ;j--) {
				a[j+1]=a[j];
			}
			a[j+1]=key;
		}

		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {2,5,1,7,3,6};

		InsertionSort sort = new InsertionSort();

		sort.Insert(a);

		for(int i : a) {
			System.out.print(i+" ");
		}
	}
}
