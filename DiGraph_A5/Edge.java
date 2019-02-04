package DiGraph_A5;

public class Edge {
	
	public long weight = 1; // default weight? 
	public long numID; 
	public String elabel; 
	public Node source; // consider making this a node , same with destination
	public Node dest; // destination
	
	public Edge(long numID, Node source, Node dest, Long weight, String elabel) { 
		if (weight.equals(null)) { 
			this.weight = 1; 
		}
		this.weight = weight; 
		this.source = source; 
		this.dest = dest; 
		this.elabel = elabel; 
		this.numID = numID; 
	}
	
	// add getters for ID and label 
	

}
