package SPLT_A4;

public class SPLT_Playground {
  public static void main(String[] args){
    genTest();
  }
  
  public static void genTest(){
    SPLT tree= new SPLT();
//    tree.insert("E");
   tree.insert("A");
//	tree.insert("A");
    tree.insert("A");
//    tree.insert("B");
 //   tree.insert("D");
 //   tree.insert("C");
//    tree.insert("E");

   // tree.findMin(); 
    //tree.contains("D");
 //  tree.remove("C");

  //  System.out.println("this is contains result: " + tree.contains("A"));
    System.out.print("root is: " + tree.root );
    
//    tree.insert("G");
//    tree.insert("K");

 //   tree.contains("A"); 
  //  System.out.println("min result: " + tree.root); 
    
    System.out.println("size is "+tree.size());
    printLevelOrder(tree);
  }

    static void printLevelOrder(SPLT tree){ 
    //will print your current tree in Level-Order...Requires a correct height method
    //https://en.wikipedia.org/wiki/Tree_traversal
      int h=tree.getRoot().getHeight();
      for(int i=0;i<=h;i++){
        System.out.print("Level "+i+":");
        printGivenLevel(tree.getRoot(), i);
        System.out.println();
      }
      
    }
    static void printGivenLevel(BST_Node root,int level){
      if(root==null)return;
      if(level==0)System.out.print(root.data+" ");
      else if(level>0){
        printGivenLevel(root.left,level-1);
        printGivenLevel(root.right,level-1);
      }
    }
   static void printInOrder(BST_Node root){
      if(root!=null){
      printInOrder(root.getLeft());
      System.out.print(root.getData()+" ");
      printInOrder(root.getRight());
      }
  }
  
}
