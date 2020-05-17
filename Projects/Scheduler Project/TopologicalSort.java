import java.util.*;
import java.lang.IllegalArgumentException;

class TopologicalSort {
	private String[] newSort = null;

	public String[] TopologicalSort(Graph<String> g, int size) {
		// list to store the sorted values
		String[] newSort = new String[size];

		// get indegree information of graph
		//List<Integer> indegree = g.getIndegree();

		// set of all nodes with no edges
		Queue<String> q = new ArrayDeque<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; i < size; j++) {
				if (!g.isEdge(i,j)) {
					String val = g.getValue(j);
					q.add(val);
				}
			}
		}

		//while nodes in active set
		int index = 0;
		int from;
		int to;
		while (!q.isEmpty()) {
			String n = q.poll();
			newSort[index++] = n;

			from = g.lookup(n);
			for (to = 0; to < size; to++) {
				if (g.isEdge(from,to)) {
					g.removeEdge(from,to);
				}
			}
			if(!g.isEdge(to,from)) {
				String sTo = g.getValue(to);
				q.offer(sTo);
			}
		}

		if (index != from) {
			throw new IllegalArgumentException("Courses are immpossible to complete.");
		}

		return newSort;
	}
}

