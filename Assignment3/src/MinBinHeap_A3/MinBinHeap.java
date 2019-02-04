package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int _size;
	private static final int arraySize = 10000;

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000);
		_size = 0;

	}

	public void insert(EntryPair entry) {

		array[++_size] = entry;
		int index = _size;
		System.out.println("This is entry priority: " + entry.priority);
		System.out.println("This is index: " + index);
		System.out.println("This is parent index: " + array[index / 2].priority);
		System.out.println("This is index array: " + array[index].priority);
		System.out.println("This is size: " + _size);

		if (_size == 1) {
			// break
		} else {
			while (array[(index / 2)].priority > array[index].priority) {

				System.out.println("This is index: " + index);
				System.out.println("This is parent index: " + array[index / 2].priority);
				System.out.println("This is index array: " + array[index].priority);
				System.out.println("This is size: " + _size);

				// swap
				EntryPair hole = array[index / 2];
				array[(index / 2)] = entry;
				array[index] = hole;
				index = index / 2;

			}
		}
	}

	public void delMin() {
		// if (size < 1) {
		// // do anything?
		// }
		System.out.println("This is size" + _size);

		array[1] = array[_size]; // this fills the root with the contents of
									// index size (the last index)
		_size--;

		int indexparent = 1;

		// bubble down following least node, start with index being

		while (indexparent < _size) {
			System.out.println("indexparent is " + indexparent);
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			if (array[(indexparent * 2) + 1] != null) { // right child and left
														// child exist
				System.out.println("start of two children case ");
				// not going through either if statement, index parent is
				// staying the same

				if (array[indexparent].priority > array[(indexparent * 2)].priority
						&& (array[(indexparent * 2)].priority <= (array[(indexparent * 2) + 1].priority))) {
					System.out.println("I'm gonna swap with the left child");

					EntryPair tmp = array[indexparent];
					array[indexparent] = array[(indexparent * 2)];
					array[(indexparent * 2)] = tmp;

					indexparent = indexparent * 2;

				} else if (array[indexparent].priority > array[(indexparent * 2) + 1].priority
						&& (array[(indexparent * 2) + 1].priority <= (array[(indexparent * 2)].priority))) {
					System.out.println("I'm gonna swap with the right child");

					EntryPair tmp = array[indexparent];
					array[indexparent] = array[(indexparent * 2) + 1];
					array[(indexparent * 2) + 1] = tmp;

					indexparent = (indexparent * 2) + 1;

				} else if (array[indexparent].priority <= array[indexparent * 2].priority
						&& array[indexparent].priority <= array[(indexparent * 2) + 1].priority) {
					indexparent = (indexparent * 2);
				}

			} else if (array[indexparent * 2] != null) { // just left child
															// exists
				System.out.println("There's only a left child");

				if (array[indexparent].priority > array[(indexparent * 2)].priority) {
					System.out.println("There's only a left child; I'm gonna swap with the left child");

					EntryPair tmp = array[indexparent];
					array[indexparent] = array[(indexparent * 2)];
					array[(indexparent * 2)] = tmp;

				}
				indexparent = indexparent * 2;

			} else if (array[indexparent * 2] == null && array[(indexparent * 2) + 1] == null) {

				break;
			}

		}
	}

	public void bubbledown(int size, int indexparent) {

	}

	public EntryPair getMin() {
		if (_size > 1) {
			return array[1];
		} else
			return null;
	}

	public int size() {
		return _size;
	}

	public void build(EntryPair[] entries) {

		_size = 0;
		EntryPair[] array = new EntryPair[entries.length + 1];
		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
			_size++;
		}

		int index = array.length - 1;

		System.out.println("this is the entries length " + entries.length);
		System.out.println("this is the index " + index);
		System.out.println("this is the size " + _size);

		// bubble section
		for (int i = index / 2; i > 0; i--) {

			// two children (if index is odd, and check for just one index at 1
			// )
			if (index % 2 == 1) {
				if (_size == 1) {
					break;
				}
				if (array[index].priority < array[index - 1].priority) {
					// swap with right
					EntryPair tmp = array[index / 2];
					array[index / 2] = array[index];
					array[index] = tmp;

				}
				if (array[index].priority > array[index - 1].priority) {
					// swap with left
					EntryPair tmp = array[index / 2];
					array[index / 2] = array[index - 1];
					array[index - 1] = tmp;
				}

			} else { // index is even so there is one child
				if (array[index / 2].priority > array[index].priority) {
					// swap with left
					EntryPair tmp = array[index / 2];
					array[index / 2] = array[index];
					array[index] = tmp;

				} else { // parent is already smaller than child
					break;
				}

			}
		}

	}

	// Please do not remove or modify this method! Used to test your entire
	// Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}
}