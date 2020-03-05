package CS3304;

public class Knapsack {

	public static void main(String[] args) {
		// initializing arrays for the values and weights of items
		int W[] = {  1, 4,  6, 2,  5, 10,  8,  3, 9,  1,  4,  2,  5,  8,   9, 1};
		int V[]  = { 10, 5, 30, 8, 12, 30, 50, 10, 2, 10, 40, 80, 100, 25, 10, 5};

		// the total size of the knapsack
		int B = 20;

		// array to save the subproblems
		int[][] k = new int[V.length+1][B+1];
		int[][] keep = new int[V.length+1][B+1];
		// initialize the solution of subproblems with no items
		// all should be zero
		for (int w = 0; w <= B; w++)
			k[0][w] = 0;

		// initialize the solution of subproblems with zero capacity
		// all should be zero
		for (int i = 0; i <= V.length; i++)
			k[i][0] = 0;


		// Solve all subproblems dynamically
		for (int i = 1; i <= V.length; i++)
			for (int w = 1; w <= B; w++){
				if ((W[i-1] <= w) && (V[i-1]+k[i-1][w-W[i-1]] > k[i-1][w])){
					k[i][w] = V[i-1]+k[i-1][w-W[i-1]];
					keep[i][w] = 1;
				}				
				else{ 
					k[i][w] = k[i-1][w];
					keep[i][w] = 0;
				}

			}

		// prints the items in the knapsack with the total
		// weight and value
		int temp = B;
		int totalWeight = 0;
		int totalValue = 0;
		System.out.print("Items in the knapsack, in tuples, (item #, value, weight) : \n");
		for (int i = V.length; i >= 1; i--){
			if (keep[i][temp] == 1){
				System.out.println("( "+i+", "+V[i-1]+", "+W[i-1]+" ) ");
				totalWeight += W[i-1];
				totalValue += V[i-1];
				temp = temp - W[i-1];
			}
		}

		System.out.println("\nTotal weight of items in the knapsack: "+ totalWeight);
		System.out.println("Total value of items in the knapsack: "+ totalValue);
		
		// for printing the values of the array of subproblems
		/*
		for (int i = 0; i <= V.length; i++) {
			for (int w = 0; w <= B; w++){
				System.out.print(k[i][w]+ "       ");
			}
			System.out.println();
		 */
	}

}


