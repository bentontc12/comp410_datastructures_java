package A5_Dijkstra;

import java.util.ArrayList;

public class Node {
	public long numID; 
	public String label; 
	public int indegree; 
	public int temp_indegree; // for use in topo sort 
	//public HashMap<Node, Edge> pointsto; // this will be used in topo sort!!
	// pass the destination node in , return the edge between them!
	//public HashMap<Node, Edge> comingin; 
	public ArrayList<Edge> incoming; 
	public ArrayList<Edge> outgoing;  
	public long dist; 
	public boolean known; 
	
	
	public Node (long numID, String label) { 
		this.numID = numID; 
		this.label = label; 
		indegree = 0; 
		temp_indegree = indegree; // for topo sort  
		// pointsto = new HashMap<Node, Edge>(); 
		// comingin = new HashMap<Node, Edge>(); 
		incoming = new ArrayList<Edge>(); 
		outgoing = new ArrayList<Edge>(); 
		dist = 10000000; 
		known = false; 
		
		
	}
	
	// method to take edges and add to pointsto array; 
	
	
}
