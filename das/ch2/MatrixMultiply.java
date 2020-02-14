package das.ch2;

public class MatrixMultiply {

	public static void main(String[] args) {
		for (int m = 1; m < 11; m++) {
			
			int n = (int)Math.pow(2, (double)m);
			System.out.println("Size: "+n);
			
			double[][] X = new double[n][n];
			double[][] Y = new double[n][n];

			double[][] Z1 = new double[n][n];
			double[][] Z2 = new double[n][n];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					X[i][j] = (int)(Math.random()*10);
					Y[i][j] = (int)(Math.random()*10);
				}

			long startTime1 = System.currentTimeMillis();

			Z1 = MatrixMultiply(X, Y);

			long endTime1 = System.currentTimeMillis();
			System.out.println("Execution time in milliseconds "+
					"(divide and conquer): "+(endTime1-startTime1));


			long startTime2 = System.currentTimeMillis();
			Z2 = MatrixMultiply(X, Y);
			long endTime2 = System.currentTimeMillis();

			System.out.println("Execution time in milliseconds "+
					"(direct): "+(endTime2-startTime2));
			
			System.out.println();
			//print(Z);
		}

	}
	/**
	 * A function that performs matrix multiplication using a 
	 * divide and conquer technique that improves runtime from
	 * O(n^3) to O(n^log2(7)) or O(2^2.81).  The program uses
	 * Strassen's method by decomposing the original matrices into
	 * seven half-size matrices.
	 * @param X n by n matrix
	 * @param Y n by n matrix
	 * @return Z, the result of multiplying the two matrices
	 */

	public static double[][] MatrixMultiply(double[][] X, double[][] Y){
		int n = X[0].length;
		if (n == 1) {
			double[][] Z = new double[1][1];
			Z[0][0] = X[0][0]*Y[0][0];
			return Z;
		}
		double[][] A = new double[n/2][n/2];
		double[][] B = new double[n/2][n/2];
		double[][] C = new double[n/2][n/2];
		double[][] D = new double[n/2][n/2];
		double[][] E = new double[n/2][n/2];
		double[][] F = new double[n/2][n/2];
		double[][] G = new double[n/2][n/2];
		double[][] H = new double[n/2][n/2];

		for (int i = 0; i < n/2; i++)
			for (int j = 0; j < n/2; j++) {
				A[i][j] = X[i][j];
				E[i][j] = Y[i][j];
			}

		for (int i = n/2; i < n; i++)
			for (int j = 0; j < n/2; j++) {
				C[i-(n/2)][j] = X[i][j];
				G[i-(n/2)][j] = Y[i][j];
			}

		for (int i = 0; i < n/2; i++)
			for (int j = n/2; j < n; j++) {
				B[i][j-(n/2)] = X[i][j];
				F[i][j-(n/2)] = Y[i][j];
			}

		for (int i = n/2; i < n; i++)
			for (int j = n/2; j < n; j++) {
				D[i-(n/2)][j-(n/2)] = X[i][j];
				H[i-(n/2)][j-(n/2)] = Y[i][j];
			}

		double[][] P1 = new double[n/2][n/2];
		double[][] P2 = new double[n/2][n/2];
		double[][] P3 = new double[n/2][n/2];
		double[][] P4 = new double[n/2][n/2];
		double[][] P5 = new double[n/2][n/2];
		double[][] P6 = new double[n/2][n/2];
		double[][] P7 = new double[n/2][n/2];

		P1 = MatrixMultiply(A, MatrixSubtract(F,H));
		P2 = MatrixMultiply(MatrixAdd(A, B), H);
		P3 = MatrixMultiply(MatrixAdd(C, D), E);
		P4 = MatrixMultiply(D, MatrixSubtract(G,E));
		P5 = MatrixMultiply(MatrixAdd(A, D), MatrixAdd(E, H));
		P6 = MatrixMultiply(MatrixSubtract(B, D), MatrixAdd(G, H));
		P7 = MatrixMultiply(MatrixSubtract(A, C), MatrixAdd(E, F));

		double[][] Z = new double[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i < n/2){
					if (j < n/2)
						Z[i][j] = P5[i][j]+P4[i][j]-P2[i][j]+P6[i][j];
					else
						Z[i][j] = P1[i][j-(n/2)]+P2[i][j-(n/2)];
				}
				else {
					if (j < n/2)
						Z[i][j] = P3[i-(n/2)][j]+P4[i-(n/2)][j];
					else
						Z[i][j] = P1[i-(n/2)][j-(n/2)]+
						P5[i-(n/2)][j-(n/2)]-
						P3[i-(n/2)][j-(n/2)]+
						P7[i-(n/2)][j-(n/2)];
				}		
			}	
		return Z;
	}

	public static double[][] MatrixAdd(double[][] X, double[][] Y){
		int n = X[0].length;
		double[][] Z = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				Z[i][j] = X[i][j]+Y[i][j];
		return Z;
	}

	public static double[][] MatrixSubtract(double[][] X, double[][] Y){
		int n = X[0].length;
		double[][] Z = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				Z[i][j] = X[i][j]-Y[i][j];
		return Z;
	}

	public static void print(double[][] X) {
		int n = X[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(X[i][j]+"  ");
			}
			System.out.println();
		}			
	}

	public static void DirectMultiply(double[][] X, double[][] Y) {
		int n = X[0].length;
		double[][] Z = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				Z[i][j] = 0;
				for (int k = 0; k < n; k++)
					Z[i][j] += X[i][k]*Y[k][j];
			}			
	}
}
