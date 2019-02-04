package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;
	BST_Node child;
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

	public boolean containsNode(String s) {

		int compareResult = this.getData().compareTo(s);

		if (compareResult > 0) {
			if (this.left == null) {
				return false;
			}

			return this.left.containsNode(s);
		} else if (compareResult < 0) {
			if (this.right == null) {
				return false;
			}
			return this.right.containsNode(s);
		} else {
			return true; // this is a match
		}
	}

	public boolean insertNode(String s) {

		int compare = s.compareTo(this.getData());

		if (compare < 0) {
			if (this.left == null) {
				this.left = new BST_Node(s);
				this.left.parent = this;
				return true;
			}
			return this.left.insertNode(s);

		} else if (compare > 0) {
			if (this.right == null) {
				this.right = new BST_Node(s);
				this.right.parent = this;
				return true;
			}
			return this.right.insertNode(s);
		}

		return false;

	}

	public boolean removeNode(String s) {

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
			return this;
		}
		return this.left.findMin();

	}

	public BST_Node findMax() {
		if (this.right == null) {
			return this;
		}

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

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}
