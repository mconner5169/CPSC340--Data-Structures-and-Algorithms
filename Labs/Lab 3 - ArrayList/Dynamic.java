class DynamicList<Type> {
	private Object[] array;
	int size;

	public DynamicList() {
		array = new Object [10];
		size = 0;
	}

	public DynamicList(int cap) {
		array = new Object [cap];
		size = 0;
	}

	public void clear(){
		size = 0;
	}

	public int size() {
		return size;
	}

	//Gets a value from a specified index
	public Type get(int index) throws IndexOutOfBoundsException {
		if (index >= size){
			throw new IndexOutOfBoundsException();
		}
		Type value = (Type)array[index];
		return value;
	}
	
	//Adds an item to the array
	public void add(Type obj) {
		array[size] = obj;
		size++;
	}
}
