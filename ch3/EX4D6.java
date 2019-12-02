package ch3;

public class EX4D6 {

	public static void main(String[] args) {
		
		// setting up the exercise conditions
		LList<Integer> list = new LList<Integer>(20);
		list.append(2);
		list.append(23);
		list.append(15);
		list.append(5);
		list.append(9);
		System.out.println(list);
		System.out.println(list.reverse());
		
	}
}
