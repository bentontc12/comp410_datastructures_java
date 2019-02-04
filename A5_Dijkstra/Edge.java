package A5_Dijkstra;

public class Edge {
	
	public long weight = 1; // default weight? 
	public long numID; 
	public String elabel; 
	public Node source; // consider making this a node , same with destination
	public Node dest; // destination
	
	public Edge(long numID, A5_Dijkstra.Node source2, A5_Dijkstra.Node dest2, Long weight, String elabel) { 
		if (weight.equals(null)) { 
			this.weight = 1; 
		}
		this.weight = weight; 
		this.source = source2; 
		this.dest = dest2; 
		this.elabel = elabel; 
		this.numID = numID; 
	}
	
	// add getters for ID and label 
	

}
