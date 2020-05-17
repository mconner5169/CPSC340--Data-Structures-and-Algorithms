import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Customer {
	private boolean arrival;
	private String name;
	private int arrivalTime;
	private int duration;

	public Customer() {
		this.arrival = true;
		String name = " ";
		this.arrivalTime = 0;
		this.duration = 0;
	}

	public Customer(boolean isArrival, String name, int arrivalTime, int duration) {
		this.arrival = isArrival;
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
	}

	public int at() {
		return arrivalTime;
   	}

	public String name() {
		return name;
	}

	public boolean isArrival() {
		return arrival;
	}

	public int duration() {
		return duration;
	}
	
	//Puts the info from the file into the instance variables
	public void getArrivalCustomer(Scanner customerFile) {
		this.arrival = true;
		this.name = customerFile.next();
		this.arrivalTime = customerFile.nextInt();
		this.duration = customerFile.nextInt();
	}
}

public class BankSim {
	public int totalWaitTime = 0;
	public int totalNumberOfCustomers = 0;
	public String customerFilePath;
	public Queue<Customer> customerQueue;
	public int currentTime;

	//Sets up the simulation
	public BankSim(String customerFilePath, Queue<Customer> customerQueue) {
		this.customerFilePath = customerFilePath;
		this.customerQueue = customerQueue;
		this.currentTime = 900;
	}

	//Adds customer to list , but location is dependent on the time
	public void addCustomerToList(Customer c, LinkedList<Customer> CustomerList) {
		if (CustomerList.isEmpty()) {
			CustomerList.add(0, c);
		}
		else if (CustomerList.get(0).at() <= c.at()) {
			CustomerList.add(c);
		}
		else {
			CustomerList.add(0, c);
		}
	}

	public void simulate() throws FileNotFoundException {
		LinkedList<Customer> CustomerList = new LinkedList<Customer>();
		Scanner customerFile = new Scanner(new File(customerFilePath));
		Customer newCustomer = new Customer();
		newCustomer.getArrivalCustomer(customerFile);
		addCustomerToList(newCustomer, CustomerList);

		//Simulates while the list isn't empty		
		while (!CustomerList.isEmpty()) {
			newCustomer = CustomerList.get(0);

			//Processes the customer's arrival if the customeris arriving for first time
			if (newCustomer.isArrival()) {
				arrival(newCustomer, customerFile, CustomerList, customerQueue);
				int waitTime = wait(newCustomer, CustomerList, customerQueue);	
				System.out.println(newCustomer.name() + " got in line " + newCustomer.at() + ".");
			
				//Saves the number of customers and wait time
				totalNumberOfCustomers = totalNumberOfCustomers + 1;
				totalWaitTime =  waitTime+ totalWaitTime;
			} 
			else {
				departure(newCustomer, CustomerList, customerQueue);
				System.out.println(newCustomer.name() + " is done at " + newCustomer.at() + ".");
			}
		}
		System.out.printf("Average customer wait time is: %.5f minutes\n", ((double)totalWaitTime/totalNumberOfCustomers));
	}

	//Processess customer arrivales
	public void arrival(Customer newCustomer, Scanner customerFile, LinkedList<Customer> CustomerList, Queue<Customer> customerQueue) {
		boolean atFront = customerQueue.isEmpty();
		int waitTime = 0;
		//Enqueue customer and removes it from the list
		customerQueue.add(newCustomer);
		CustomerList.remove(0);
		if (currentTime < newCustomer.at()) {
			currentTime = newCustomer.at();
		}
		
		//Customer's departure time is added to the list	
		if (atFront) {
			addCustomerToList(new Customer(false, newCustomer.name(), currentTime+newCustomer.duration(), 0), CustomerList);
		}

		//Adds next customer from file to the list
		if (customerFile.hasNext()) {
			Customer c = new Customer();
			c.getArrivalCustomer(customerFile);
			addCustomerToList(c, CustomerList);
		}
	}

	//Gets the wait time of the person in the queue	
	public int wait(Customer newCustomer, LinkedList<Customer> CustomerList, Queue<Customer> customerQueue) {
		int waitTime = 0;
		int startTime = 0;
		int finishTime = 0;

		newCustomer = customerQueue.peek();
		Customer oldCustomer = CustomerList.get(0);
		if (customerQueue.size() == 0) {
			startTime = newCustomer.at();
		}
		else {
			//This startTime is when the newCustomer is going to be seen
			startTime = oldCustomer.at() + oldCustomer.duration();
		}
		//The time the customer in the queue is finished
		finishTime = startTime + newCustomer.duration();
		waitTime = finishTime - startTime;
		
		//Sets the waitTime to zero is there is no wait time
		if (waitTime < 0) {
			waitTime = 0;
		}
		return waitTime;
	}

	//Processess customers departure
	public void departure(Customer newCustomer, LinkedList<Customer> CustomerList, Queue<Customer> customerQueue) {
		//Dequeues customer and removes from list
		customerQueue.remove();
		CustomerList.remove(0);
		if (currentTime < newCustomer.at()) {
			currentTime = newCustomer.at();
		}
		//Customer's departure is added to the list if the queue is not empty
		if (!customerQueue.isEmpty()) {
			if (currentTime < customerQueue.peek().at()) {
				currentTime = customerQueue.peek().at();
			}
			addCustomerToList(new Customer(false, newCustomer.name(), currentTime+customerQueue.element().duration(), 0), CustomerList);
		}
	}

	public static void main(String[] args) {
		Queue<Customer> customerQueue = new LinkedList<Customer>();
		BankSim simulation = new BankSim(args[0], customerQueue);
		try {
			simulation.simulate();
		} 
		catch (FileNotFoundException e) {
			System.out.println("No such file exists.");
		}
	}
}
