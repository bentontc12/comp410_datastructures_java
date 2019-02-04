package A5_Dijkstra;

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
 
 		d.addNode(1, "f");
		d.addNode(3, "s"); 
		d.delNode("x"); 
	
		print(d); 
		
		
		
//		ShortestPathInfo[] info = d.shortestPath("p"); 
//		for (int i = 0; i < info.length; i++) { 
//			System.out.println(i);
//			System.out.println(info[i].toString()); 
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