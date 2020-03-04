package CS3304;

public class Knapsack {

	public static void main(String[] args) {

		int W[] = {  1, 4,  6, 2,  5, 10,  8,  3, 9,  1,  4,  2,  5,  8,   9, 1};
		int V[]  = { 10, 5, 30, 8, 12, 30, 50, 10, 2, 10, 40, 80, 100, 25, 10, 5};
		int B = 20;
		
		int[][] k = new int[V.length][W.length+1];

		for (int w = 0; w <= B; w++)
			k[0][w] = 0;

		for (int i = 0; i < V.length; i++)
			k[i][0] = 0;
					
		for (int i = 0; i < V.length; i++)
			for (int w = 1; w <= B; w++){
				if (W[i] <= w)
					k[i][w] = Math.max(V[i]+k[i-1][w-W[i]], k[i-1][w]);
				else
					k[i][w] = k[i-1][w];
			}
		
		System.out.println(k[V.length-1][W.length]);
	}

}
