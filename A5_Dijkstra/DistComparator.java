package A5_Dijkstra;

import java.util.Comparator;


import A5_Dijkstra.Node; 


public class DistComparator implements Comparator<Node> {

	@Override
	public int compare(Node a, Node b) {
		return a.dist < b.dist ? -1 : a.dist == b.dist ? 0:1;
		
		// returns -1 if a is less than b 
		// returns 0 if they're equal 
		// returns 1 if a is greater than b 
	}

}

