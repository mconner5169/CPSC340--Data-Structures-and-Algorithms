public class Lab6Main {
	public static void main(String args[]) {
		DoubleList<String> names = new DoubleList<String>();
		names.addEnd("Arthur");
		names.addEnd("Beatrice");
		names.addEnd("Charlie");
		names.addEnd("Daniella");
		names.addEnd("Eustace");

		System.out.println("The list:");
		names.printForwards();

		System.out.println("~~~");
		System.out.println("Slot 2 = " + names.get(2));

		System.out.println("~~~");
		System.out.println("After removing the first node:");
		names.removeFirst();
		names.printForwards();

		System.out.println("~~~");
		System.out.println("After removing the last node:");
		names.removeLast();
		names.printForwards();

		System.out.println("~~~");
		System.out.println("After Clearing:");
		names.clear();
		names.printForwards();
	}
}
