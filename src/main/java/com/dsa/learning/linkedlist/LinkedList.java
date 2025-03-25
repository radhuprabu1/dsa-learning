/**
 * 
 */
package com.dsa.learning.linkedlist;

import lombok.ToString;

/**
 * 
 */
@ToString
public class LinkedList {

	// A node class will be having a data and a pointer ( which is a node by itself)
	@ToString
	class Node {
		int data;
		// Next node will be having the pointer address of the nxt element in the linkedlist.
		Node next;
		Node(int value) {
			data = value;
			next = null;
		}
	}
	Node head;

	// Constructor to initialise LinkedList to declare head pointer (node) as null for the 
	// first element in the linkedList.
	public LinkedList() {
		head = null;
	}

	public void insertAtBeginning(int value) {
		Node newNode = new Node(value);
		// When list is empty
		if(head == null) {
			head = newNode;
		}
		else { // if list not empty
			//First set the pointer of the new node from the previously 
			// existing head value
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

	public void insertAtPosition(int position, int value) {
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
	}

	public void deleteAtPosition(int position) {
		Node temp = head;
		Node prev = null;
		for(int i=1; i<=position;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		
	}
}
