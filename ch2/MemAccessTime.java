package ch2;

public class MemAccessTime {

	public static void main(String[] args) {
		boolean[] arrBool = new boolean[100000000];
		for (int i = 0; i < arrBool.length; i++) {
			arrBool[i] = true;
		}
		
		boolean a;
		double startTime = System.currentTimeMillis();
		for (int i = 0; i < arrBool.length; i++) {
			a = arrBool[i];
		}
		double endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		char[] arrChar = new char[100000000];
		for (int i = 0; i < arrChar.length; i++) {
			arrChar[i] = 1;
		}
		
		char b;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < arrChar.length; i++) {
			b = arrChar[i];
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		int[] arrInt = new int[100000000];
		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = 1;
		}
		
		int c;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < arrInt.length; i++) {
			c = arrInt[i];
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		long[] arrLong = new long[100000000];
		for (int i = 0; i < arrLong.length; i++) {
			arrLong[i] = 1;
		}
		
		long d;
		startTime = System.currentTimeMillis();
		for (int i = 0; i < arrLong.length; i++) {
			d = arrLong[i];
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);

	}

}
