package DiGraph_A5;

import java.util.Iterator;
import java.util.Map;

public class DiGraphPlayground {

	public static void main(String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like
		// -- print
		// -- sort
		// -- random fill
		// -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		exTest();
	}

	public static void exTest() {
		DiGraph d = new DiGraph();
//		d.delNode("f"); 
		d.addNode(1, "f");
		d.addNode(3, "s");
	//	d.addNode(7, "t");
		//d.addNode(0, "fo");
		//d.addNode(4, "fi");
//		d.addNode(6, "si");
//		d.addEdge(0, "f", "s", 0, null);
//		d.addEdge(1, "f", "si", 0, null);
		// t's incoming 
		
		d.delNode("f"); 
//		d.addNode(3, "f");
	//	d.delNode("f"); 
		
		
		
//		d.addEdge(0, "s", "t", 0, null);
//		d.addEdge(3, "fo", "fi", 0, null);
//		d.addEdge(4, "fi", "si", 0, null);
//		d.delEdge("f", "s");
//		d.addEdge(0, "f", "s", 0, null);
//		d.addEdge(0, "f", "s", 0, null);
//		d.delEdge("s", "t");
//		d.delEdge("f", "si"); 
//		d.delEdge("f", "s"); 
//		d.delEdge("f", "s"); 
//		d.addEdge(3, "s", "fo", 2, null); 
//		d.delNode("fi"); 
		// System.out.println("incoming of si " + d.numEdges());
//		d.delNode("f"); 
		print(d);
		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());
	}

	public static void print(DiGraph d) { 
		Iterator it = d.nodeHM.entrySet().iterator(); 
		while (it.hasNext()) {
		Map.Entry pair = (Map.Entry)it.next();
		Node n = (Node)pair.getValue();
    	System.out.println("("+ n.numID + ") " + n.label);
    		for (Edge e : n.outgoing ) { 
    		System.out.println("  ("+ e.numID +") -- " + e.weight + "--> " + e.dest.label);
    		} 
    		for (Edge e : n.incoming)
    		 System.out.println("incoming of: " + n.label + " is " + e.numID);
    	} 
	}
}