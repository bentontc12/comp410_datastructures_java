package SPLT_A4;

import SPLT_A4.BST_Node;

public class SPLT implements SPLT_Interface {
	public BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	public BST_Node getRoot() { // please keep this in here! I need your root
								// node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		if (size == 0) {
			root = new BST_Node(s);
			size += 1;
			return;
		}
		root = root.insertNode(s);
		if (root.justmade) {
			root.justmade = false;
			size++;
		}
	}

	public void remove(String s) {
		
		if (contains(s)) { 
			
			BST_Node leftsubtree = root.left;
			BST_Node rightsubtree = root.right; 
			root.left = null;
			root.right = null;
			
			if (leftsubtree != null) { 		
				
				root = leftsubtree; 
				leftsubtree.parent = null; 
				leftsubtree.findMax(); 
				
				if (rightsubtree !=null) { 
				
				leftsubtree.right = rightsubtree; 
				rightsubtree.parent = leftsubtree;
				}

				
			} else if (rightsubtree != null) {
				root = rightsubtree;
				root.parent = null;
			}

			size--;
		}
			
		else { 
			// do nothing, it was never removed 
		}
	} 	
		

	public String findMin() {
		if (empty()) {
			return null;
		} else {
			root = root.findMin(); 
			return root.getData();
		}
	}

	public String findMax() {
		if (empty()) {
			return null;
		} else {
			root = root.findMax(); 
			return root.data;
		}
	}

	public boolean empty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setRoot(BST_Node x) {
		root = x;
	}

	public boolean contains(String s) {
		if (!empty()) {
			
			root = root.containsNode(s); 
			// ^ that should set EITHER the s or s.parent to root 
			if (root.getData().equals(s)) {
				return true;
			} else {
				return false;
			}
		}
		else return false; 
	}

	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

}

