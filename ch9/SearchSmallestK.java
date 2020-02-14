package ch9;

/**
 * This class has a method that calculates the kth
 * smallest value in an unsorted array by borrowing
 * ideas from the quicksort algorithm, it selects a pivot
 * and then partitions the array into two, it then calculates
 * the partition boundary and compares it with the value k
 * The method calls itself recursively on the part of the array
 * where k lies, eventually, the algorithm finds the kth smallest
 * value in the unsorted array.
 * @author Abdulrahman
 *
 */
public class SearchSmallestK {
	public static void main(String[] args) {
		Integer[] arr = new Integer[20];
		int k = 5;
		System.out.println("The original array is:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (Integer)(int)(Math.random()*200);
			System.out.print(arr[i]+ " ");
		}
		
		System.out.println("\nThe smallest k = "+
							k+" element is: "+findSmallestK(arr, k));
		
		System.out.println();
		quicksort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		
	}
	
	static Comparable findSmallestK(Comparable[] arr, int k) {
		return findSmallestK(arr, 0, arr.length-1, k);
	}
	static Comparable findSmallestK(Comparable[] arr, int min, int max, int k) {
		int pivotIndex = (min+max)/2;
		swap(arr, pivotIndex, max);
		int p = partition(arr, min, max);
		swap(arr, p, max);
		if (p == k-1) return arr[k-1];
		else if ((p-min) > 1 && k   < p+1) return findSmallestK(arr, min, p-1, k);
		else if ((max-p) > 1 && p+1 < k  ) return findSmallestK(arr, p+1, max, k);
		return arr[k-1];
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
	
	static void quicksort(Comparable[] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	static void quicksort(Comparable[] arr, int min, int max) {
		int pivotIndex = (min+max)/2;
		swap(arr, pivotIndex, max);
		int p = partition(arr, min, max);
		swap(arr, p, max);
		if ((p-min) > 1) quicksort(arr, min, p-1);
		if ((max-p) > 1) quicksort(arr, p+1, max);
	}
}
