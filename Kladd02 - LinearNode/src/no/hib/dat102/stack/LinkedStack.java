package no.hib.dat102.stack;

import no.hib.dat102.adt.StackADT;

public class LinkedStack<T> implements StackADT<T> {
	private int count;
	private LinearNode<T> top;

	/**
	 * Oppretter en tom stabel
	 */
	public LinkedStack() {
		count = 0;
		top = null;
	}

	@Override
	public void push(T element) {
		LinearNode<T> temp = new LinearNode<T>(element);

		temp.setNext(top);
		top = temp;
		count++;
	}

	@Override
	public T pop() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		T result = top.getElement();
		top = top.getNext();
		count--;

		return result;
	}

	@Override
	public T peek() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		return top.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public int size() {
		return count;
	}
	
} // class
