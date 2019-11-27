package ch2;
/**
 * A binary search function that returns
 * the index of the first occurrence of
 * an element in an array
 * @author Abdulrahman
 *
 */

public class BinSearchFirst {
	public static void main(String args[]) {
		int[] A = new int[20];
		for (int i = 0; i < A.length; i++) {
			A[i] = i/4;
		}
		
		// test cases
		System.out.println(find(A, -1));
		System.out.println(find(A, 0));
		System.out.println(find(A, 1));
		System.out.println(find(A, 2));
		System.out.println(find(A, 3));
		System.out.println(find(A, 4));
		System.out.println(find(A, 5));
	}
	public static int find(int[] A, int K) { 
		int low = 0;
		int hi = A.length-1;
		int mid;
		while (low <= hi) {
			mid = (hi+low)/2;
			if (A[mid] > K)
				hi = mid-1;
			else if (A[mid] < K)
				low = mid+1;
			else {
				if (mid == 0) {
					return mid;
				}
				if(A[mid-1] != K) {
					return mid;
				}
				else
					hi = mid-1;
			}
		}
		return -1;
	}
}

