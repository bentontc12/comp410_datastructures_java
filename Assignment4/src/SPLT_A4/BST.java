package SPLT_A4;

import SPLT_A4.BST_Interface;
import SPLT_A4.BST_Node;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	public boolean insert(String s) {
		if (size == 0) {
			root = new BST_Node(s);
			size++;
			return true;
		}
		root = root.insertNode(s);
		if (root.justmade) {
			size++;
			return true;
		}
		return false;
	}

	public boolean remove(String s) {

		if (size == 0) {
			return false;
		}

		if (s == root.getData()) {
			if (root.left == null) {
				root = root.right;
				size--;
				return true;
			}
			if (root.right == null) {
				root = root.left;
				size--;
				return true;
			}
		}

		if (s == root.getData() && size == 1) {
			root = null;
			size--;
			return true;
		}

		if (root.removeNode(s)) {
			size--;
			return true;
		}
		return false;
	}

	public String findMin() {
		if (size == 0) {
			return null;
		}
		return root.findMin().getData();

	}

	public String findMax() {
		if (size == 0) {
			return null;
		}
		return root.findMax().getData();
	}

	public boolean empty() {
		return (size == 0);

	}

	public boolean contains(String s) {
		if (size == 0) {
			return false;
		}
		if (root.containsNode(s) == null ) { 
			return false; 
		}
		else return true; 

	}

	public int size() {
		return size;
	}

	public int height() {
		if (size == 0) {
			return 0;
		}
		return root.getHeight();
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}



}
