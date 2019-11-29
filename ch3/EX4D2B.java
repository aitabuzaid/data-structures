package ch3;

public class EX4D2B {

	public static void main(String[] args) {
		
		// setting up the exercise conditions
		List<Integer> list = new AList<Integer>();
		System.out.println(list);
		list.append(2);
		System.out.println(list);
		list.append(23);
		System.out.println(list);
		list.append(15);
		System.out.println(list);
		list.moveToStart();
		System.out.println(list);
		list.insert(39);
		System.out.println(list);
		list.next();
		System.out.println(list);
		list.insert(12);
		System.out.println(list);
	}

}
