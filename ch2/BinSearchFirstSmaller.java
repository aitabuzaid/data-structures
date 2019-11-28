package ch2;
/**
 * A binary search function that returns
 * the index of the first occurrence of
 * an element in an array that is smaller
 * than K when K is not in the array
 * @author Abdulrahman
 *
 */

public class BinSearchFirstSmaller {
	public static void main(String args[]) {
		int[] A = new int[20];
		for (int i = 0; i < A.length; i++) {
			A[i] = 2*i;
			System.out.println(i+" : "+A[i]);
		}
		
		// test cases
		System.out.println(find(A, -1));
		System.out.println(find(A, 0));
		System.out.println(find(A, 1));
		System.out.println(find(A, 2));
		System.out.println(find(A, 3));
		System.out.println(find(A, 4));
		System.out.println(find(A, 45));
	}
	public static int find(int[] A, int K) { 
		int low = 0;
		int hi = A.length-1;
		int mid = (hi+low)/2;
		while (low <= hi) {
			mid = (hi+low)/2;
			if (A[mid] > K)
				hi = mid-1;
			else if (A[mid] < K)
				low = mid+1;
			else {
				return mid;
			}
		}
		if (mid > 0) {
			if (A[mid] < K)
				return mid;
			else if (A[mid-1] < K)
				return mid-1;
		}
		else if (mid == 0 && A[mid] < K)
			return mid;
		return -1;
		
	}
}

