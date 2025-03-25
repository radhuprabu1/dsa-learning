/**
 * 
 */
package com.dsa.learning.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 */
public class DynamicArray<T> implements Iterable<T>{

	private T arr[]; // Array to store elements
	private int size;
	private int capacity;
	private static final int initialCapacity = 3;

	@SuppressWarnings("unchecked")
	public DynamicArray() {
		size = 0;
		arr = (T[]) new Object[initialCapacity]; // Create a generic array
		capacity = initialCapacity;

	}

	public void add(T value) {

		if(size == capacity) {
			expandArray();
		}
		arr[size++] = value;
	}

	public void display() {
		System.out.println("Elements in the list:");
		for(int i=0; i<size; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	/**
	 * @param position
	 * @param val
	 */
	public void insertAtPosition(int position, T value) {
		if(position>capacity) {
			System.out.println("Enter a valid position");
		}
		if(position == capacity) {
			expandArray();
		}
		for(int i=size-1; i>=position; i--) {
			arr[i+1] = arr[i];
		}
		arr[position] = value;
		size++;
	}

	/**
	 * @param position
	 */
	public void deleteAtPosition(int position) {
		if(position > size) {
			System.out.println("Enter a valid position");
		}
		for(int i=position+1; i<=size-1; i++) {
			arr[i-1] = arr[i];
		}
		size--;
		if(capacity > 3*size && capacity > initialCapacity) {
			shrinkArray();
		}
	}

	/**
	 * 
	 */
	public void deleteAtEnd() {
		deleteAtPosition(size);		
	}

	/**
	 * @param position
	 * @param val
	 */
	public void update(int position, T value) {
		arr[position] = value;
	}

	/**
	 * @param val
	 */
	public T search(T value) {
		T index = null;
		for(int i=0; i<size; i++) {
			if(arr[i] == value) {
				index = value;
			}
		}
		return index;
	}

	/**
	 * 
	 */
	public void clear() {
		for(int i=0; i<size; i++) {
			arr[i] = null;
		}
	}

	/**
	 * @param val
	 */
	public boolean contains(T val) {

		for(int i=0; i<size; i++) {
			if(arr[i] == val) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	private void expandArray() {
		capacity *= 2;
		arr = java.util.Arrays.copyOf(arr, capacity);
	}

	/**
	 * 
	 */
	private void shrinkArray() {
		capacity /= 2;
		arr = java.util.Arrays.copyOf(arr, capacity);
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index =0;
			@Override
			public boolean hasNext() {
				return index < size; // If index less than size return true
			}

			@Override
			public T next() {
				if (!hasNext()) {
          throw new NoSuchElementException();
      }
				return arr[index++];
			}

		};
	}


}
