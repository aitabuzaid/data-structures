package ch3;

public class EX4D1 {

	public static void main(String[] args) {
		
		// setting up the exercise conditions
		List<Integer> list = new AList<Integer>();
		list.append(2);
		list.append(23);
		list.append(15);
		list.append(5);
		list.append(9);
		list.moveToStart();
		
		// Solving the exercise
		list.moveToPos(2);
		list.remove();
		System.out.println(list);
	}

}
