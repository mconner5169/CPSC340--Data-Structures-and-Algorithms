import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;

class TopologicalSort {
	private int[][] newSort = new int[0][0];
	private Queue<Integer> q = new ArrayDeque<>();

	public int[][] TopologicalSort(Graph<String> g) throws IllegalArgumentException {
		int size = g.getSize();
		
		// list to store the sorted values
		newSort = new int[size][size];
		int index = 0;
		int fro = 1; // N
		int t = 1; // M

		// set ordering to empty
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				newSort[i][j] = 0;
			}
		}

		// searches for node with no edge and adds to queue		
		for (fro = 0; fro < size; fro++) {
			for (t = 0; t < size; t++) {
				if (g.isEdge(fro,t) == 0) {
					String val = g.getValue(fro);
					int valNum = g.lookup(val);
					q.add(valNum);
				}
			}
		}

		//while node's in active set
		while (!q.isEmpty()) {
			// moves node from queue into the new array
			int loc = q.poll();
			newSort[index][index] = loc;
			index++;

			// remove the edge coming out of N (from) and checks for incoming edges
			int from = loc;
			for (int to = 0;  g.isEdge(from,to) == 1; to++) {
				g.removeEdge(from,to);
				for (int adjNode = 0; adjNode < size; adjNode++) {
					if (g.isEdge(adjNode,to) == 0) {
						String toValue = g.getValue(to);
						int toValueNum = g.lookup(toValue);
						q.add(toValueNum);
					}
				}
			}
		}

		// checks graph for leftover edges
		for (int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if (g.isEdge(i,j) == 1) {
			throw new IllegalArgumentException("Courses are immpossible to complete.");
				}
			}
		}

		return newSort;
	}
}

public class Scheduler {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		Graph<String> graf = null;

		try {
			Scanner tempScan = new Scanner(new FileReader(args[0]));

			//gets size and sets graph size
			int nodeNum = tempScan.nextInt();
			graf = new Graph<String>(nodeNum);
			int size = graf.getSize();

			//puts nodes into graph
			int node = 0;
			String line = null;
			while(tempScan.hasNext()) {
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
			while(tempScan2.hasNext()) {
				mainClass = tempScan2.next();
				if(mainClass.equals("")) {
					break;
				}
				numEdge = tempScan2.nextInt();

				//finds node with no edges
				if(numEdge == 0) {
					int mainClassNodeNum = graf.lookup(mainClass);

					// creates an edge from the start node to same node then removes it
					graf.insertEdge(mainClassNodeNum,mainClassNodeNum);
					graf.removeEdge(mainClassNodeNum,mainClassNodeNum);

					numEdge = -1;
				}

				// inserts an edge from the prereq to the main class
				for(int i = 0; i < numEdge; i++) {
					prereq = tempScan2.next();
					graf.insertEdge(prereq,mainClass);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("No such file exists.");
			System.exit(1);
		}

		//Performs topological ordering
		System.out.println("Topologically sorted order: { ");
		TopologicalSort sort = new TopologicalSort();

		int[][] newSort = sort.TopologicalSort(graf);
		
		// prints order
		for (int i = 0; i < newSort.length; i++) {
			for (int j = 0; j < newSort.length; j++) {
				System.out.print(newSort[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print(" }");
	}
}	
