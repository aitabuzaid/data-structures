package ch3;

//Circular Linked list implementation
class CircularLList<E> implements List<E> {
	private Link<E> head;      // Pointer to list header
	private Link<E> tail;      // Pointer to last element
	private Link<E> curr;      // Access to current element
	private Link<E> temp;
	private int listSize;      // Size of list

	// Constructors
	CircularLList(int size) { this(); }     // Constructor -- Ignore size
	CircularLList() { clear(); }

	// Remove all elements
	public void clear() {
		curr = tail = new Link<E>(null); // Create trailer
		head = new Link<E>(tail);        // Create header
		tail.setNext(head);
		listSize = 0;
	}

	// Insert "it" at current position
	public boolean insert(E it) {
		curr.setNext(new Link<E>(curr.element(), curr.next()));
		curr.setElement(it);
		if (tail == curr) {
			tail = curr.next();  // New tail
			tail.setNext(head);
		}
		listSize++;
		return true;
	}

	// Append "it" to list
	public boolean append(E it) {
		tail.setNext(new Link<E>(null));
		tail.setElement(it);
		tail = tail.next();
		tail.setNext(head);
		listSize++;
		return true;
	}

	// Remove and return current element
	public E remove () {
		if (curr == tail) return null;          // Nothing to remove
		E it = curr.element();                  // Remember value
		curr.setElement(curr.next().element()); // Pull forward the next element
		if (curr.next() == tail) {
			tail = curr;   // Removed last, move tail
			tail.setNext(head);
		}
		curr.setNext(curr.next().next());       // Point around unneeded link
		listSize--;                             // Decrement element count
		return it;                              // Return value
	}

	public void moveToStart() { curr = head.next(); } // Set curr at list start
	public void moveToEnd() { curr = tail; }     // Set curr at list end

	// Move curr one step left; no change if now at front
	public void prev() {
		if (head.next() == curr) return; // No previous element
		Link<E> temp = head;
		// March down list until we find the previous element
		while (temp.next() != curr) temp = temp.next();
		curr = temp;
	}

	// Move curr one step right; no change if now at end
	public void next() { if (curr != tail) curr = curr.next(); }

	public int length() { return listSize; } // Return list length


	// Return the position of the current element
	public int currPos() {
		Link<E> temp = head.next();
		int i;
		for (i=0; curr != temp; i++)
			temp = temp.next();
		return i;
	}

	// Move down list to "pos" position
	public boolean moveToPos(int pos) {
		if ((pos < 0) || (pos > listSize)) return false;
		curr = head.next();
		for(int i=0; i<pos; i++) curr = curr.next();
		return true;
	}

	// Return true if current position is at end of the list
	public boolean isAtEnd() { return curr == tail; }

	// Return current element value. Note that null gets returned if curr is at the tail
	public E getValue() {
		return curr.element();
	}

	public String toString() {
		Link<E> temp = head.next();
		StringBuffer out = new StringBuffer((listSize + 1) * 4);

		out.append("< ");
		for (int i = 0; i < currPos(); i++) {
			out.append(temp.element());
			out.append(" ");
			temp = temp.next();
		}
		out.append("| ");
		for (int i = currPos(); i < listSize; i++) {
			out.append(temp.element());
			out.append(" ");
			temp = temp.next();
		}
		out.append(">");
		return out.toString();
	}

	//Tell if the list is empty or not
	public boolean isEmpty() {
		return listSize == 0;
	}
	
	public boolean swap() {return false;}
	
	public CircularLList<E> reverse() {
		this.moveToStart();
		CircularLList<E> llist = new CircularLList<E>(this.length());
		temp = head.next();
		while (temp.next() != null){
			llist.insert(temp.element());
			temp = temp.next();
		}
		return llist;
	}
}