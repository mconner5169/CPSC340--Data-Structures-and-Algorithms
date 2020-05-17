import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
  
    class Customer {
        private boolean arrival;
		private String name;
        private int start;
        private int span;
        
        public Customer() {
            this.arrival = true;
			String name = " ";
            this.start = 0;
            this.span = 0;
        }
        
        public Customer(boolean isArrival, String name, int startTime, int span) {
            this.arrival = isArrival;
			this.name = name;
            this.start = startTime;
            this.span = span;
        }
        
        public int at() { return start; }
		public String name() { return name; }
        public boolean isArrival() { return arrival; }
        public int duration() { return span; }
        
        public void getArrivalCustomer(Scanner arrivalFile) {
            this.arrival = true;
			this.name = arrivalFile.next();
            this.start = arrivalFile.nextInt();
            this.span = arrivalFile.nextInt();
        }

		@Override
			public String toString() {
				String customerInfo = " ";
				customerInfo = this.name;
				return customerInfo;
			}
	}

public class SimulationQueue {
	public String arrivalFilePath;
	public int currentTime;

    public SimulationQueue(String arrivalFilePath) {
        this.arrivalFilePath = arrivalFilePath;
        this.currentTime = 900;
    }
    
    private void addCustomerToList(Customer c, List<Customer> CustomerList) {
        if (CustomerList.isEmpty()) CustomerList.add(0, c);
        else if (CustomerList.get(0).at() < c.at()) CustomerList.add(c);
        else CustomerList.add(0, c);
    }
    
    public void simulate() throws FileNotFoundException {
        Queue<Customer> bankQueue = new LinkedList<Customer>();
        List<Customer> CustomerList = new LinkedList<Customer>();
        Scanner arrivalFile = new Scanner(new File(arrivalFilePath));
        Customer newCustomer = new Customer();
        newCustomer.getArrivalCustomer(arrivalFile);
        addCustomerToList(newCustomer, CustomerList);
        
        while (!CustomerList.isEmpty()) {
            newCustomer = CustomerList.get(0);
            if (newCustomer.isArrival()) {
                System.out.printf("%s got in line at %d\n", newCustomer.name(), newCustomer.at());
                processArrival(newCustomer, arrivalFile, CustomerList, bankQueue);
            } else {
                System.out.printf("%s is done at %d\n", newCustomer.name(), newCustomer.at());
                processDeparture(newCustomer, CustomerList, bankQueue);
            }
        }
    }
    
    private void processArrival(Customer newCustomer, Scanner arrivalFile, List<Customer> CustomerList, Queue<Customer> bankQueue) {
        boolean atFront = bankQueue.isEmpty();
        bankQueue.add(newCustomer);
        CustomerList.remove(0);
        if (currentTime < newCustomer.at()) currentTime = newCustomer.at();
        
        if (atFront) {
            addCustomerToList(new Customer(false, newCustomer.name(), currentTime+newCustomer.duration(), 0), CustomerList);
        }
        
        if (arrivalFile.hasNext()) {
            Customer c = new Customer();
            c.getArrivalCustomer(arrivalFile);
            addCustomerToList(c, CustomerList);
        }
    }
    
    private void processDeparture(Customer newCustomer, List<Customer> CustomerList, Queue<Customer> bankQueue) {
        bankQueue.remove();
        CustomerList.remove(0);
        if (currentTime < newCustomer.at()) currentTime = newCustomer.at();
        
        if (!bankQueue.isEmpty()) {
            if (currentTime < bankQueue.peek().at()) currentTime = bankQueue.peek().at();
            addCustomerToList(new Customer(false, newCustomer.name(), currentTime+bankQueue.element().duration(), 0), CustomerList);
        }
    }
    
    
    public static void main(String [] args) {
        SimulationQueue simulation = new SimulationQueue(args[0]);
        try {
            simulation.simulate();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
