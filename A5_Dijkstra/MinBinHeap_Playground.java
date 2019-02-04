package A5_Dijkstra;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    TestBuild();
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
//    MinBinHeap mbh= new MinBinHeap();
//    EntryPair[] collection= new EntryPair[6];
//    collection[0]=new EntryPair("b",1);
//    collection[1]=new EntryPair("c",4);
//    collection[2]=new EntryPair("t",2);
//    collection[3]=new EntryPair("e",8);
//    collection[4]=new EntryPair("a",5);
//    collection[5]=new EntryPair("z",7);
//    collection[6]=new EntryPair("g",6);
//    collection[7]=new EntryPair("h",17);
//    System.out.println("Collection length is " + collection.length); 
//    mbh.build(collection);
//    printHeapCollection(collection);
//    
//    printHeap(mbh.getHeap(), mbh.size());
	  
	  MinBinHeap mbh = new MinBinHeap(); 
	  EntryPair entry1 = new EntryPair("a", 5); 
	  EntryPair entry2 = new EntryPair("b", 4); 
	  EntryPair entry3 = new EntryPair("c", 3); 
	  EntryPair entry4 = new EntryPair("d", 2); 
	  EntryPair entry5 = new EntryPair("e", 1); 
//	  EntryPair entry6 = new EntryPair("a", 5); 
	  
//	  // create a test where no swaps are necessary
//	  
//
	  mbh.insert(entry1);
	  printHeap(mbh.getHeap(), mbh.size()); 
	  mbh.insert(entry2);
	  printHeap(mbh.getHeap(), mbh.size()); 
	  mbh.insert(entry3);
	  printHeap(mbh.getHeap(), mbh.size()); 
	  mbh.insert(entry3);
	  printHeap(mbh.getHeap(), mbh.size()); 
	  mbh.insert(entry4);
	  printHeap(mbh.getHeap(), mbh.size()); 
	  mbh.insert(entry4);
	  mbh.delMin();
	  System.out.println("Print after deleting min ");
	  printHeap(mbh.getHeap(), mbh.size());
	  mbh.delMin();
	  System.out.println("Print after deleting min ");
	  printHeap(mbh.getHeap(), mbh.size());
////	  System.out.println("Print after deleting min");
//	  printHeap(mbh.getHeap(), mbh.size()); 
//	  mbh.insert(entry4);
//	  printHeap(mbh.getHeap(), mbh.size());
//	  mbh.insert(entry5);
//	  printHeap(mbh.getHeap(), mbh.size()); 
//	  mbh.insert(entry6);
//	  printHeap(mbh.getHeap(), mbh.size()); 
//	  mbh.delMin();
// 	  System.out.println("Print after deleting min");
//	  printHeap(mbh.getHeap(), mbh.size()); 


	  
	  
//	  
	 
  }
  
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
        System.out.println("this is e[i] " + e[i]);


      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}