package A5_Dijkstra;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;


import A5_Dijkstra.Node;
import A5_Dijkstra.Edge;

public class DiGraph implements DiGraph_Interface {
	HashMap<String, Node> nodeHM;
	HashMap<Long, Edge> edgeHM;
	HashMap<Long, String> nodeHM_check;
	

	int numEdges = 0;
	int numNodes = 0;

	// Long shortestpathdist = (long) 0;

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
		if (nodeHM_check.containsKey(idNum)) {
			return false;
		}

		else {
			Node tempvar = new Node(idNum, label);
			nodeHM_check.put(idNum, label);
			nodeHM.put(label, tempvar);
			numNodes++;
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
		}
		

		Node source = nodeHM.get(sLabel);
		Node dest = nodeHM.get(dLabel);
		
		if (source == null || dest == null) { 
			return false; 
		}

		Edge tempvar = new Edge(idNum, source, dest, weight, eLabel);
		edgeHM.put(idNum, tempvar);

		dest.incoming.add(tempvar);
		System.out.println("source: " + source);
		System.out.println("source outgoin: " + source.outgoing);
		System.out.println("tempvar: " + tempvar);

		

		source.outgoing.add(tempvar); // this will return a node so you
										// can update node class
		dest.indegree++;
		dest.temp_indegree++;
		numEdges++;
		return true;

	}

	public boolean delNode(String label) {

		Node node = nodeHM.get(label);
		ArrayList<Edge> todelete = new ArrayList<Edge>();

		Iterator<Edge> iter = node.incoming.iterator();
		
		
		while (iter.hasNext()) {
			Edge e = iter.next();
			todelete.add(e);
			// delEdge(e.source.label, e.dest.label);
		}

		Iterator<Edge> itera = node.outgoing.iterator();
		while (itera.hasNext()) {
			Edge e = itera.next();
			todelete.add(e);
			// delEdge(e.source.label, e.dest.label);
		}
		for (Edge e : todelete) {
			delEdge(e.source.label, e.dest.label);
		}

		// for (Edge e: node.incoming) { // remove all edges in node's incoming
		// delEdge(e.source.label, e.dest.label);
		// }
		// for (Edge e: node.outgoing) { // remove all edges in node's outgoing
		// delEdge(e.source.label, e.dest.label);
		// }

		nodeHM_check.remove(node.numID); // remove from hashmap
		nodeHM.remove(label); // remove from hashmap
		numNodes--;

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
			for (Edge e : source.outgoing) { // find the matching edge, given
												// the source and dest
				if (e.dest == dest) {
					match = e;
					source.outgoing.remove(match);
					dest.incoming.remove(match);
					break;
				}
			}
			if (match != null) {
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

	public String[] topoSort() {
		// TsODO Auto-generated method stub
		return null;
	}

	public ShortestPathInfo[] shortestPath(String label) {
		
		Node s = nodeHM.get(label);
		s.dist = 0; // individual node's dist value 
		
	// 	Node f = new Node(1, "f", ) // maybe make nodes to test the comparable if you need to  
		
		MinBinHeap PQ = new MinBinHeap(); 
		// PriorityQueue<Node> PQ = new PriorityQueue<Node>(nodeHM.size());// to hold adjacent nodes 
		ShortestPathInfo[] array = new ShortestPathInfo[nodeHM.size()]; 
		
		int counter = 0; 
		EntryPair ep = new EntryPair(s.label, (int) s.dist); 
		PQ.insert(ep); 
		System.out.println("pq get min is " + PQ.getMin());
		while (PQ.getMin()!=null) { 
			System.out.println("Hi in the loop");
			Node n = nodeHM.get(PQ.getMin().value);  
			Long d = n.dist; 
			PQ.delMin(); 
			
			if (n.known == true) { // already accounted for, can't output it  
				continue; // skips the rest of the loop and starts the loop over  
			}
			else { 
				n.known = true; 
				ShortestPathInfo object = new ShortestPathInfo(n.label, n.dist); 
				array[counter] = object; 
				counter ++; 
				System.out.println(object.toString());
				 
				for (Edge e: n.outgoing) { 
				Node a = e.dest; 
				
				if (a.dist > d + e.weight) { 
					a.dist = d + e.weight; 
					EntryPair entrypair = new EntryPair(a.label, (int) a.dist); 
					PQ.insert(entrypair);
				}
				// update distance only for the shortest node's distance
					// iterate through outgoing 
					// add current distance with the weight of the edge 
					// compare added distance with current distance, save the smaller one 
				
				// insert updated only if it's smaller than the current distance? 
			}
			
		
	
			}
		}
		return array;  // 
	}

	/*
	 * return: array of ShortestPathInfo objects (ShortestPathInfo) length of
	 * this array should be numNodes (as you will put in all shortest paths
	 * including from source to itself) See ShortestPathInfo class for what each
	 * field of this object should contain
	 */
	// rest of your code to implement the various operations
	// public ShortestPathInfo convert(Node s) {
	// String label = s.label;
	// Long nodedist = s.dist;
	//
	// ShortestPathInfo spObject = new ShortestPathInfo(label, nodedist +
	// shortestpathdist);
	// // hopefully this will update the path distance along the way?? each time
	// i add a new sp object?
	// return spObject;
	// }
}
