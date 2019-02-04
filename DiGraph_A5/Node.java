package DiGraph_A5;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
	public long numID; 
	public String label; 
	public int indegree; 
	public int temp_indegree; // for use in topo sort 
	//public HashMap<Node, Edge> pointsto; // this will be used in topo sort!!
	// pass the destination node in , return the edge between them!
	//public HashMap<Node, Edge> comingin; 
	public ArrayList<Edge> incoming; 
	public ArrayList<Edge> outgoing;  
	public int dist; 
	
	
	public Node (long numID, String label) { 
		this.numID = numID; 
		this.label = label; 
		indegree = 0; 
		temp_indegree = indegree; // for topo sort  
		
		incoming = new ArrayList<Edge>(); 
		outgoing = new ArrayList<Edge>(); 
		dist = 1000000; 
		
	}


	@Override
	public int compareTo(Node a) {
		return a.dist < this.dist ? -1 : a.dist == this.dist ? 0:1;
		
		// returns -1 if a is less than this 
		// returns 0 if they're equal 
		// returns 1 if a is greater than this 
	}


	
	// method to take edges and add to pointsto array; 
	
	
}
