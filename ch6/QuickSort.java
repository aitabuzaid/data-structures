package ch6;

public class QuickSort {
	public static void main(String[] args) {
		System.out.print("Hi");
	}
	
	static void quicksort(Comparable[] arr, int min, int max) {
		int pivotIndex = (min+max)/2;
		swap(arr, pivotIndex, max);
		int p = partition(arr, min, max);
		swap(arr, p, max);
		if ((p-min) > 1) quicksort(arr, min, p-1);
		if ((max-p) > 1) quicksort(arr, p+1, max);
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
			while((arr[right].compareTo(arr[pivotIndex]) >= 0) && (right >= left)) right--;
			if (right > left) swap(arr, left, right);
		}
		return left;
	}
}
