/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the
					// head)
	int size;

	public LinkedListImpl() {// this constructor is needed for testing purposes.
								// Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part
								// of your data set!
		size = 0;
	}

	public boolean insert(double elt, int index) {

		if (index > size || index < 0) {
			return false;
		}

		// size is 0 (base case)
		if (this.size == 0) {
			Node insert = new Node(elt);
			sentinel.next = insert;
			sentinel.prev = insert;
			insert.next = sentinel;
			insert.prev = sentinel;
			size++;
			return true;
		}

		else {

			Node temp1 = sentinel;
			for (int x = 0; x <= index; x++) {
				temp1 = temp1.next;
			}

			Node temp0 = temp1.prev;
			Node insert = new Node(elt);

			insert.prev = temp0;
			temp0.next = insert;
			insert.next = temp1;
			temp1.prev = insert;

			size++;
			return true;

		}
	}

	public boolean remove(int index) {
		if (index >= size || index < 0 || size == 0) {
			return false;

		}

		// case where size == 1
		if (size == 1) {
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
			size = 0;
			return true;
		}

		// general
		else {

			Node temp1 = sentinel;
			for (int x = 0; x <= index; x++) {
				temp1 = temp1.next;
			}

			Node temp0 = temp1.prev;
			Node temp2 = temp1.next;
			temp0.next = temp2;
			temp2.prev = temp0;

			size--;
			return true;
		}
	}

	public double get(int index) {

		if (index >= size || size == 0) {
			return Double.NaN;
		}

		Node temp = sentinel;
		for (int x = 0; x <= index; x++) {
			temp = temp.next;
		}

		return temp.getData();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}

	}

	public void clear() {

		sentinel.next = sentinel;
		sentinel.prev = sentinel;

		size = 0;
	}

	public Node getRoot() { // leave this method as is, used by the grader to
							// grab your linkedList easily.
		return sentinel;
	}
}