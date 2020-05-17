public class BigInt {
	private int[] bigArray;
	private int[] newArry;
	private boolean leadingzeros = false;

	public BigInt() {
		leadingzeros = false;
		bigArray = new int [65];
		for (int i = 0; i < bigArray.length; i++) {
			bigArray[i] = 0;
		}
	}

	//sets the bigint to the number passed
	public BigInt(int number) {
		leadingzeros = true;
		bigArray = new int [number];
		int index = 0;	
		bigArray[index] = number;
	}

	public BigInt(String num) {
		leadingzeros = false;
		bigArray = new int [num.length()];
		//Reading string from right to left and putting values into array
		int index = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			bigArray[index] = Integer.parseInt(num.substring(i, i + 1));
			index++;
		}
	}

	@Override
		public String toString() {
			String bigIntString = "";

			//Prints array that doesn't include zeros
			if (leadingzeros == false) {
				//Concatinates the value at i to the bigIntString
				for (int i = 0; i < bigArray.length; i++) {
					bigIntString = bigArray[i] + bigIntString;
				}
			}

			//Deletes zeros from array then prints array
			else if (leadingzeros == true) {
				for (int i = bigArray.length - 1; i >= 0; i--) {
					if(bigArray[i] != 0){
						bigIntString = bigArray[i] + bigIntString;
					}
				}
			}

			return bigIntString;
		}
	public int compareTo(BigInt arry) {
		int result = 0;

		if (this.bigArray.length > arry.bigArray.length) {
			//Making new array that fills empty spaces with zeros at start of array
			int addSpace = this.bigArray.length - arry.bigArray.length;
			newArry = new int [arry.bigArray.length + addSpace];
			for (int i = addSpace - 1; i >= 0; i--) {
				newArry[addSpace] = 0;
			}

			//Appending arry.bigArray values to new array after the zeros
			int	j = 0;
			for (int i = addSpace; i > arry.bigArray.length; i++) {
				newArry[i] = arry.bigArray[j];
				j++;
			}

			//Compares this.array to the parameter array
			for (int i = this.bigArray.length - 1; i>= 0; i--) {
				if (this.bigArray[i] > newArry[i]) {
					result = 1;
				}
				else if (this.bigArray[i] < newArry[i]) {
					result = -1;
				}
				else if (this.bigArray[i] == newArry[i]) {
					result = 0;
				}
			}
		}
		else if (this.bigArray.length < arry.bigArray.length) {
			//Makes new array that fills empty spaces with zeros at start of array
			int addSpace = arry.bigArray.length - this.bigArray.length;
			newArry = new int [this.bigArray.length + addSpace];
			for (int i = addSpace - 1; i >= 0; i--) {
				newArry[i] = 0;
			}

			//Append this.bigArray values to new array after the zeros
			int j = 0;
			for (int i = addSpace; i < newArry.length; i++) {
				newArry[i] = this.bigArray[j];
				j++;
			}
			//Copying the newArry back into the this.bigArray
			this.bigArray = new int [this.bigArray.length + addSpace];
			j = 0;
			for (int i = 0; i < newArry.length; i++) {
				this.bigArray[j] = newArry[i];
				j++;
			}

			//Comparing new array with the other array
			for (int i = this.bigArray.length - 1; i >= 0; i--) {
				if (this.bigArray[i] > arry.bigArray[i]) {
					result = 1;
				}
				else if (this.bigArray[i] < arry.bigArray[i]) {
					result = -1;
				}
				else if (this.bigArray[i] == arry.bigArray[i]) {
					result = 0;
				}
			}
		}
		else {
			//Compares this.array to the parameter array
			for (int i = this.bigArray.length - 1; i >= 0; i--) {
				if (this.bigArray[i] > arry.bigArray[i]) {
					result = 1;
				}
				else if (this.bigArray[i] < arry.bigArray[i]) {
					result = -1;
				}
				else if (this.bigArray[i] == arry.bigArray[i]) {
					result = 0;
				}
			}
		}
		return result;
	}

	public BigInt add (BigInt n) {
		BigInt sum = new BigInt();

		int carryNum = 0;
		for (int i = 0; i < n.bigArray.length; i++) {
			sum.bigArray[i] = (this.bigArray[i] + n.bigArray[i] + carryNum) % 10;
			carryNum = (this.bigArray[i] + n.bigArray[i] + carryNum)/10;
		}
		return sum;
	}

}
