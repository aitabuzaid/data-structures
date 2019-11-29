package ch3;

public class EX4D4 {

	public static void main(String[] args) {
		
		// setting up the exercise conditions
		List<Integer> list = new AList<Integer>(20);
		list.append(2);
		list.append(23);
		list.append(15);
		list.append(5);
		list.append(9);
		list.moveToPos(3);
		System.out.println(list);
		System.out.println(list.swap());
		System.out.println(list);
	}
}
