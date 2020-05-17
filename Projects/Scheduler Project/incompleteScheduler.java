import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Scheduler {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		int edgeTotal = 0;

		try {
			Scanner tempScan = new Scanner(new FileReader(args[0]));

			//gets size and sets graph size
			int nodeNum = tempScan.nextInt();
			Graph<String> graf = new Graph<String>(nodeNum);
			int size = graf.getSize();

			//puts nodes into graph
			int node = 0;
			String line = null;
			while(tempScan.hasNextLine()) {
				//reads node value and inserts into graph
				line = tempScan.next();
				graf.setValue(node,line);

				//reads past the current line
				tempScan.nextLine();
				node = node + 1;
			}

			tempScan.close();

			//opens new Scanner
			Scanner tempScan2 = new Scanner(new FileReader(args[0]));

			//adds edges
			String mainClass = null;
			String prereq = null;
			int numEdge = 0;

			//Reads past the node number
			tempScan2.nextLine();

			//creates edges from the prereq classes to the main class
			while(tempScan2.hasNextLine()) {
				mainClass = tempScan2.next();
				numEdge = tempScan2.nextInt();
				
				//keeping track of total number of edges
				edgeTotal = edgeTotal + numEdge;

				//finds node with no edges
				if(numEdge == 0) {
					prereq = null;
					//System.out.println(mainClass + " doesn't have prerequisites.");
					edgeTotal = edgeTotal + numEdge;
					numEdge = 1;
				}


				for(int i = 0; i < numEdge; i++) {
					prereq = tempScan2.next();
					graf.insertEdge(prereq,mainClass);

					//Debugging to make sure the edge is connected
					int preq = graf.lookup(prereq);
					int core = graf.lookup(mainClass);
					if(graf.isEdge(preq,core)) {
						System.out.println(prereq + " and " + mainClass + " are an edge.");
					}
					else {
						System.out.println(prereq + " and " + mainClass + " are not edges.");
					}
				}
			}

			tempScan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("No such file exists.");
			System.exit(1);
		}

		//Performs topological ordering
		System.out.println("Topologically sorted order: ");

		//make space for values
		int size = graf.getSize();
		String[] sortedArray = new String[size];

		//active set
		Queue<String> workingQ = new ArrayDeque<>();
		
		//Finding nodes with no edges
		for (int from = 0; i < edgeTotal; from++) {
			for (int to = 0; to < edgeTotal; to++) {
				if (!graf.isEdge(from,to)) {
					String class1 = graf.getValue(from);
					workingQ.offer(class1);
				}
			}
		}

		int ind1ex = 0;
		while (!workingQ.isEmpty()) {
			String at = workingQ.poll();
			sortedArray[index++] = at;
			for ( : graf.
		if (index != size) {
			throw new IllegalArgumentException("Programs are incomplete to p    rocess.");
		}
		//prints the new order
		for (int i = 0; i <= size; i++) {
			System.out.println(sortedArray[i]);
		}
	}
}	
