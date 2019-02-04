package DiGraph_A5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import A5_Dijkstra.ShortestPathInfo;

public class DiGraph implements DiGraph_Interface {
	HashMap<String, Node> nodeHM;
	HashMap<Long, Edge> edgeHM;
	HashMap<Long, String> nodeHM_check;

	int numEdges = 0;
	int numNodes = 0;

	// in here go all your data and methods for the graph

	public DiGraph() { // default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there
		nodeHM = new HashMap<String, Node>(); // use this to return a node for
												// updating points to array
		nodeHM_check = new HashMap<Long, String>(); // idNum and label; use in
													// addnode to check for
													// uniqueness

		edgeHM = new HashMap<Long, Edge>();

		// always update both node HashMaps

	}

	// keep some sort of sorted list for printing out??
	// TOPO sort:

	// loop through set (or hashmap?) and find any with an indegree of 1
	// manipulate tempindegree

	public boolean addNode(long idNum, String label) {
		if (idNum < 0) {
			return false;
		}
		if (nodeHM.containsKey(label)) {
			return false;
		}

		else {
			Node tempvar = new Node(idNum, label);
			nodeHM_check.put(idNum, label);
			nodeHM.put(label, tempvar);
			numNodes++;
			
			// print what's in node HM here 
			System.out.println(nodeHM.keySet());
			// for every node I want to know it's incoming and dest array lists 
			
			return true;
		}

	}

	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if (idNum < 0) {
			return false;
		}
		// check for duplicate edges
		if (edgeHM.containsKey(idNum)) {
			return false;
			// why isn't this catching the duplicate edge? 
		}
		// check for source and dest actually existing 
		Node source = nodeHM.get(sLabel);
		Node dest = nodeHM.get(dLabel);
		if (nodeHM.containsKey(sLabel) == false || nodeHM.containsKey(dLabel) == false) { 
			return false; 
		}

		Edge tempvar = new Edge(idNum, source, dest, weight, eLabel);
		System.out.println("This is the edge: " + tempvar.numID);
		System.out.println("tempvar is: " + tempvar);
		
		edgeHM.put(idNum, tempvar);
		source.outgoing.add(tempvar); // this will return a node so you
											// can update node class
		dest.indegree++;
		dest.temp_indegree++;
		numEdges++;
		return true;

	}

public boolean delNode(String label) {
	
	if (!nodeHM.containsKey(label)) { 
		return false; 
	}
	 
	Node node = nodeHM.get(label); 
	ArrayList<Edge> todelete = new ArrayList<Edge>(); 
	
	Iterator<Edge> iter = node.incoming.iterator(); 
	while (iter.hasNext()) { 
		Edge e = iter.next();
		todelete.add(e);
		//delEdge(e.source.label, e.dest.label); 
	}

	Iterator<Edge> itera = node.outgoing.iterator();
	while (itera.hasNext()) { 
		Edge e = itera.next(); 
		todelete.add(e); 
		//delEdge(e.source.label, e.dest.label); 
	}
	for (Edge e: todelete) { 
		delEdge(e.source.label, e.dest.label ); 
	}
	
//	for (Edge e: node.incoming) { // remove all edges in node's incoming
//		delEdge(e.source.label, e.dest.label); 
//	}
//	for (Edge e: node.outgoing) { // remove all edges in node's outgoing 
//		delEdge(e.source.label, e.dest.label); 
//	}
	
	nodeHM_check.remove(node.numID); // remove from hashmap
	nodeHM.remove(label); // remove from hashmap
	numNodes --; 
	
	return false;
}

	public boolean delEdge(String sLabel, String dLabel) {
		// check hashmaps
		if (!nodeHM.containsKey(sLabel) || !nodeHM_check.containsKey(nodeHM.get(sLabel).numID)) {
			return false;
		}
		if (!nodeHM.containsKey(dLabel) || (!nodeHM_check.containsKey(nodeHM.get(dLabel).numID))) {
			return false;
		}

		else { 
			Node source = nodeHM.get(sLabel);
			Node dest = nodeHM.get(dLabel);

			// delete edge 
			Edge match = null; 
			for (Edge e: source.outgoing)  { // find the matching edge, given the source and dest 
				if (e.dest == dest) { 
					match = e; 	
					source.outgoing.remove(match); 
					dest.incoming.remove(match); 
					break; 
				} 
			} 		
			if(match != null) {
				edgeHM.remove(match.numID); // remove from hashmap	
				
				dest.indegree--;
				dest.temp_indegree--;
				numEdges--;
				return true;
			}
			return false; 
		}
	}

	public long numNodes() {
		return numNodes;
	}

	public long numEdges() {
		return numEdges;
	}
	
	
	/* return: array of ShortestPathInfo objects (ShortestPathInfo)
            length of this array should be numNodes (as you will put in all shortest 
            paths including from source to itself)
            See ShortestPathInfo class for what each field of this object should contain
*/
	
	// rest of your code to implement the various operations
}
