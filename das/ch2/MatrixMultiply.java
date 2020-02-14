package das.ch2;

public class MatrixMultiply {

	public static void main(String[] args) {
		

	}
	
	public double[][] MatrixMultiply(double[][] X, double[][] Y){
		int n = X[0].length;
		double[][] A = new double[n][n];
		double[][] B = new double[n][n];
		double[][] C = new double[n][n];
		double[][] D = new double[n][n];
		double[][] E = new double[n][n];
		double[][] F = new double[n][n];
		double[][] G = new double[n][n];
		double[][] H = new double[n][n];
		
		for (int i = 0; i < (int)Math.ceil(n/2); i++)
			for (int j = 0; j < (int)Math.ceil(n/2); j++) {
				A[i][j] = X[i][j];
				E[i][j] = Y[i][j];
			}
		
		for (int i = (int)Math.ceil(n/2); i < n; i++)
			for (int j = 0; j < (int)Math.ceil(n/2); j++) {
				C[i][j] = X[i][j];
				G[i][j] = Y[i][j];
			}
		
		for (int i = 0; i < (int)Math.ceil(n/2); i++)
			for (int j = (int)Math.ceil(n/2); j < n; j++) {
				B[i][j] = X[i][j];
				F[i][j] = Y[i][j];
			}
		
		for (int i = (int)Math.ceil(n/2); i < n; i++)
			for (int j = (int)Math.ceil(n/2); j < n; j++) {
				D[i][j] = X[i][j];
				H[i][j] = Y[i][j];
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
				if (i < Math.ceil(n/2)){
					if (j < Math.ceil(n/2))
						Z[i][j] = P5[i][j]+P4[i][j]-P2[i][j]+P6[i][j];
					else
						Z[i][j] = P1[i][j]+P2[i][j];
				}
				else {
					if (j < Math.ceil(n/2))
						Z[i][j] = P3[i][j]+P4[i][j];
					else
						Z[i][j] = P1[i][j]+P5[i][j]-P3[i][j]+P7[i][j];
				}		
			}	
		return Z;
	}
	
	public double[][] MatrixAdd(double[][] X, double[][] Y){
		int n = X[0].length;
		double[][] Z = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				Z[i][j] = X[i][j]+Y[i][j];
		return Z;
	}
	
	public double[][] MatrixSubtract(double[][] X, double[][] Y){
		int n = X[0].length;
		double[][] Z = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				Z[i][j] = X[i][j]-Y[i][j];
		return Z;
	}

}
