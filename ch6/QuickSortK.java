package ch6;

public class QuickSortK {
	public static void main(String[] args) {
		Integer[] arr = new Integer[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (Integer)(int)(Math.random()*200);
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		quicksort(arr, 10);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	static void quicksort(Comparable[] arr, int k) {
		quicksort(arr, 0, arr.length-1, k);
	}
	static void quicksort(Comparable[] arr, int min, int max, int k) {
		int pivotIndex = (min+max)/2;
		swap(arr, pivotIndex, max);
		int p = partition(arr, min, max);
		swap(arr, p, max);
		if ((p-min) > 1 && min < k) quicksort(arr, min, p-1, k);
		if ((max-p) > 1 && p < k) quicksort(arr, p+1, max, k);
	}

	static void swap(Comparable[] arr, int p1, int p2) {
		Comparable temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}
	
	static int partition(Comparable[] arr, int left, int right) {
		int pivotIndex = right--;
		while (left <= right) {
			while(arr[left].compareTo(arr[pivotIndex]) < 0) left++;
			//System.out.println(left+" "+right);
			while((right >= left) && (arr[right].compareTo(arr[pivotIndex]) >= 0)) right--;
			if (right > left) swap(arr, left, right);
		}
		return left;
	}
}
