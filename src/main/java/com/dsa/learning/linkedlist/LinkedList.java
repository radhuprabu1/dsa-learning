/**
 * 
 */
package com.dsa.learning.linkedlist;

import java.util.Iterator;

import lombok.ToString;

/**
 * 
 */
@ToString
public class LinkedList<T> implements Iterable<T> {

	// A node class will be having a data and a pointer ( which is a node by itself)
	@ToString
	class Node {
		T data;
		// Next node will be having the pointer address of the nxt element in the linkedlist.
		Node next;
		Node(T value) {
			data = value;
			next = null;
		}
	}
	Node head;

	// Constructor to initialise LinkedList to declare head pointer (node) as null for the first element in the linkedList.
	public LinkedList() {
		head = null;
	}

	public void insertAtBeginning(T value) {
		Node newNode = new Node(value);
		// When list is empty
		if(head == null) {
			head = newNode;
		}
		else { // if list not empty
			//First set the pointer of the new node from the previously existing head value
			newNode.next = head;
			// Now fix the head as the newNode.
			head = newNode;
		}
	}

	public void display() {
		Node temp = head; // start from the head
		while(temp != null) { // null implies end of the list
			System.out.print(temp.data + " ");
			temp = temp.next; // jump
		}
		System.out.println("");
	}

	public void insertAtPosition(int position, T value) {
		Node newNode = new Node(value);
		Node temp = head;
		if(position == 0) {
			insertAtBeginning(value);
			return;
		}

		for(int i=1; i<position; i++) {
			temp = temp.next;
			if(temp==null) {
				throw new IllegalArgumentException("Invalid Position");
			}
		}

		newNode.next = temp.next;
		temp.next = newNode;
		display();
	}

	public void deleteAtPosition(int position) {
		Node temp = head;
		Node prev = null;
		for(int i=1; i<=position;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;

		display();

	}

	public void getValueAtPosition(int position) {
		Node temp = head;
		
		for(int i=0; i<=position; i++) {
			if(i==position) {
				System.out.println("The value of data at index " + position + " is " +temp.data);
			}
			temp = temp.next;
		}
	}

	public void updateAtPosition(int position, T value) {
		Node temp = head;
		for(int i=0; i<=position; i++) {
			if(i == position) {
				temp.data = value;
				display();
				return;
			}
			temp = temp.next;
		}
	}

	public void insertAtEnd(T value) {
		int position = getEndPosition();
		insertAtPosition(position, value);
	}

	private int getEndPosition() {
		Node temp = head;
		int position = -1;
		while(temp != null) {
			temp = temp.next;
			position++;
		}
		return position;
	}

	public void deleteAtEnd() {
		int position = getEndPosition();
		deleteAtPosition(position);
	}

	public void searchValue(T value) {
		Node temp = head;
		int position = getEndPosition();
		for(int i=0; i<=position; i++) {
			if(temp.data == value) {
				System.out.println("Index of the value is at " + i);
				return;
			}
			temp = temp.next;
		}
	}
	
	public boolean containsValue(T value) {
		boolean hasValue = false;
		Node temp = head;
		int position = getEndPosition();
		for(int i=0; i<=position; i++) {
			if(temp.data == value) {
				System.out.println("The list has "+ value + " - " + hasValue);
				return true;
			}
			temp = temp.next;
		}
		System.out.println("The list doesn't has "+ value +  " - " + hasValue);
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node temp = head;
			@Override
			public boolean hasNext() {
				return temp!=null;
			}

			@Override
			public T next() {
				
				T value = temp.data;
				temp = temp.next;
				return value;
			}
		};
	}

	public void displayFromIterator(LinkedList<T> linkedList) {
		for(T value : linkedList) {
			System.out.print(value + " ");
		}
	}
}
