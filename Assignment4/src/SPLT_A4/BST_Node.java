package SPLT_A4;

import SPLT_A4.BST_Node;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;
	BST_Node child;
	BST_Node toSplay;
	BST_Node GP_leftchild;
	BST_Node GP_rightchild;
	boolean justmade = true;
	int height = 0;
	int lh;
	int rh;

	BST_Node(String data) {
		this.data = data;

	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public BST_Node containsNode(String s) {
		
		System.out.print("I'm in Contains ");
		System.out.print("this: " + this.getData());

		int compareResult = this.getData().compareTo(s);
		System.out.print("this is the compareResult: " + compareResult);
		if (compareResult == 0) {
			splay(this);
			return this; // this is a match
			// return true; 
			
		} else if (compareResult > 0) {
			if (this.left == null) {
				splay(this); // splay the node before you get to the null child
				return this;
				// return false; 
			}
			toSplay = this.left;
			return this.left.containsNode(s);
		} else if (compareResult < 0) {
			if (this.right == null) {
				splay(this); // splay the node before you get to the null child
				return this;
				// return false; 
			}
			toSplay = this.right;
			return this.right.containsNode(s);
		} else { 
		return null;
	}
	}
	public BST_Node insertNode(String s) {
		System.out.println("I'm in insertNode");

		int compare = s.compareTo(this.getData());

		if (compare < 0) {
			if (this.left == null) {
				this.left = new BST_Node(s);
				toSplay = this.left;
				this.left.parent = this;
				splay(toSplay);
				return toSplay;
			}
			return this.left.insertNode(s);

		} else if (compare > 0) {
			if (this.right == null) {
				this.right = new BST_Node(s);
				toSplay = this.right;
				this.right.parent = this;
				splay(toSplay);
				return toSplay;

			}
			return this.right.insertNode(s);
		}
		//
		splay(this);
		 justmade = false; 
		return this;

	}

	public boolean removeNode(String s) {
		// return a node 
		
		
		int compare = this.getData().compareTo(s);

		if (compare < 0) { // the node to remove is on the right
			System.out.println("I'm in compare < 0");

			if (this.right != null) {
				System.out.println("I'm in there is right node");
				return this.right.removeNode(s);
			}
		} else if (compare > 0) { // the node to remove is on the left
			System.out.println("I'm in compare > 0");
			if (this.left != null) {
				System.out.println("I'm in there is left node");
				return this.left.removeNode(s);
			}
		}

		else {

			// case for no children
			if (this.left == null && this.right == null) {

				if (parent.right != null && parent.right.getData() == s) {
					parent.right = null;
					this.parent = null;
					return true;
				}
				if (parent.left != null && parent.left.getData() == s) {
					parent.left = null;
					this.parent = null;
					return true;
				}

			}
			// case for one child
			if ((this.left != null && this.right == null) || (this.left == null && this.right != null)) {

				if (parent.left != null && parent.left.getData().compareTo(this.getData()) == 0) {

					if (this.left != null && this.right == null) {
						parent.left = this.left;
						this.left.parent = this.parent;
						this.parent = null;
						return true;
					}

					if (this.left == null && this.right != null) {
						parent.left = this.right;
						this.right.parent = this.parent;
						this.parent = null;
						return true;
					}

				}
				if (parent.right != null && parent.right.getData().compareTo(this.getData()) == 0) {

					if (this.left != null && this.right == null) {
						parent.right = this.left;
						this.left.parent = this.parent;
						this.parent = null;
						return true;

					}

					if (this.right != null && this.left == null) {
						parent.right = this.right;
						this.right.parent = this.parent;
						this.parent = null;
						return true;
					}
				}

			}
			// case for 2 children
			if (this.left != null && this.right != null) {
				String min = this.right.findMin().getData();
				this.data = min;
				return this.right.removeNode(min);
			}

		}
		return false;

	}

	public BST_Node findMin() {
		if (this.left == null) {
			splay(this);
			return this;
		}
		toSplay = this.left;
		return toSplay.findMin();

	}

	public BST_Node findMax() {
		if (this.right == null) {
			splay(this);
			return this;
		}
		toSplay = this.right;
		return this.right.findMax();

	}

	public int getHeight() {
		if (this.left == null && this.right == null) { // no children
			return height;

		}
		if (this.left != null && this.right == null) { // left child, take the
														// left path
			return this.left.getHeight() + 1;
		}
		if (this.right != null && this.left == null) { // right child, take the
														// right path
			return this.right.getHeight() + 1;
		} else { // two children
			lh = this.left.getHeight();
			rh = this.right.getHeight();

			if (lh > rh) {
				return lh + 1;
			} else {
				return rh + 1;
			}
		}
	}

	
	private void splay(BST_Node x) {
		System.out.println("I'm in splay");

		
		
		if (x.parent == null) {
			return; // x is already the root
		}
		
		while (x.parent != null) {

		
			// no grandparents
			if (x.parent.parent == null) {
				if (x == x.parent.left) {
					rotateRight(x);
				}
				else if (x == x.parent.right) {
					rotateLeft(x);
				}
			}

			else if (x.parent.parent != null) {
				// case 1
				
				if (x == x.parent.left && x.parent == x.parent.parent.left) { 
					rotateRight(x.parent); 
					rotateRight(x);
				}

				// case 2
				
				else if (x == x.parent.right && x.parent == x.parent.parent.right) { 
					rotateLeft(x.parent); 
					rotateLeft(x);
				}

				// case 3 
				else if (x == x.parent.right && x.parent == x.parent.parent.left) {
					//
					rotateLeft(x);
					rotateRight(x);
				}
				

				// case 4
				else if (x == x.parent.left && x.parent == x.parent.parent.right) {
					rotateRight(x);
					rotateLeft(x);
				}
				else { 
					System.out.print("I didn't fall into an if statement");
				}
			}
		}
	}

	private void rotateRight(BST_Node x) {
		System.out.print("I'm in rotate Right");
		BST_Node parent = x.parent;
		BST_Node grandparent = x.parent.parent;
		BST_Node x_right = x.right;

		// required reassignments with or without kids, grandparents
		
		parent.parent = x;
		parent.left = x_right;
		x.right = parent; 

		// if grandparent
		if (grandparent != null) {

			if (grandparent.left == parent) {
				grandparent.left = x;
			} else if (grandparent.right == parent) {
				grandparent.right = x;
			}
		}
		// if child // am I checking if parent?
		if (x_right != null) {
			x_right.parent = parent; 
		}
		x.parent = grandparent; 
	}

	private void rotateLeft(BST_Node x) {
		System.out.print("I'm in rotate Left");

		BST_Node parent = x.parent;
		BST_Node grandparent = x.parent.parent;
		BST_Node x_left = x.left;
		// required reassignments with or without kids, grandparents
		parent.parent = x;
		parent.right = x_left;
		x.left = parent;
		
		
		// if grandparent
		
		// x.parent = grandparent; 
		if (grandparent != null) {

			if (grandparent.right == parent) {
				grandparent.right = x;
			} else if (grandparent.left == parent) {
				grandparent.left = x;
			}
		}
		// if child
		if (x_left != null) {
			x_left.parent = parent;
		}
		x.parent = grandparent;
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}
