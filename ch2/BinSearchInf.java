package ch2;
/**
 * A binary search function for infinite
 * arrays. The function is still Theta(log n)
 * where n is the smallest value larger than K
 * Finding n is done in log (n) steps in
 * the first while loop while the second
 * while loop searches for K within the index
 * element 0 and n.
 * 
 * After the value of n is found, the binary
 * search algorithm is used as is with hi = n
 * 
 * The infinite array is simulated by using
 * a big value for the array size, 10000. 
 * @author Abdulrahman
 *
 */

public class BinSearchInf {
	public static void main(String args[]) {
		int[] A = new int[10000];
		for (int i = 0; i < A.length; i++) {
			A[i] = 2*i;
			//System.out.println(i+" : "+A[i]);
		}
		
		// test cases
		System.out.println(find(A, -1));
		System.out.println(find(A, 0));
		System.out.println(find(A, 1));
		System.out.println(find(A, 2));
		System.out.println(find(A, 3));
		System.out.println(find(A, 4));
		System.out.println(find(A, 10002));
	}
	public static int find(int[] A, int K) { 
		int n = 1;
		while (A[n] < K) {
			n *= 2;
		}
		int low = 0;
		int hi = n;
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
		return -1;
		
	}
}

