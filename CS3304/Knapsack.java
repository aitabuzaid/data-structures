package CS3304;

public class Knapsack {

	public static void main(String[] args) {
		// initializing arrays for the values and weights of items
		int W[] = {  1, 4,  6, 2,  5, 10,  8,  3, 9,  1,  4,  2,  5,  8,   9, 1};
		int V[]  = { 10, 5, 30, 8, 12, 30, 50, 10, 2, 10, 40, 80, 100, 25, 10, 5};
		
		// the total size of the knapsack
		int B = 20;
		
		int[][] k = new int[V.length+1][B+1];

		for (int w = 0; w <= B; w++)
			k[0][w] = 0;

		for (int i = 0; i <= V.length; i++)
			k[i][0] = 0;
					
		for (int i = 1; i <= V.length; i++)
			for (int w = 1; w <= B; w++){
				if (W[i-1] <= w)
					k[i][w] = Math.max(V[i-1]+k[i-1][w-W[i-1]], k[i-1][w]);
				else
					k[i][w] = k[i-1][w];
			}
		
		for (int i = 0; i <= V.length; i++) {
			for (int w = 0; w <= B; w++){
				System.out.print(k[i][w]+ "       ");
			}
			System.out.println();
		}
			
	}

}
