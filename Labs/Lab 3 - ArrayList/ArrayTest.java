public class ArrayTest {
	public static void main(String args[]) {
		DynamicList<String> names = new DynamicList<String>(15);

		names.add("Alice");
		names.add("Billy");
		names.add("Claire");
		names.add("Donovan");
		names.add("Ethel");
		names.add("Frank");
		names.add("Gina");
		names.add("Hank");
		names.add("Ima");
		names.add("Joel");
		names.add("Kathy");
		names.add("Leon");
		names.add("Marion");
		names.add("Neville");
		names.add("Ophelia");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		names.clear();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
	}
}
