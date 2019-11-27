package ch2;

public class BinSearchFirst {
	public static void main(String args[]) {
		int[] A = new int[20];
		for (int i = 0; i < A.length; i++) {
			A[i] = i/4;
			System.out.println(i+" : "+A[i]);
		}
		System.out.println(find(A, 2));
	}
	public static int find(int[] A, int K) { 
		int low = 0;
		int hi = A.length-1;
		int mid;
		while (low <= hi) {
			mid = (hi-low)/2;
			if (A[mid] > K)
				hi = mid;
			else if (A[mid] < K)
				low = mid;
			else {
				if (mid == 0) {
					return mid;
				}
				if(A[mid-1] != K) {
					return mid;
				}
				else
					hi = mid;
			}
		}
		return -1;
	}
}

