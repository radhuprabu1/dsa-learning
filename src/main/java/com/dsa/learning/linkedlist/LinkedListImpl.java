/**
 * 
 */
package com.dsa.learning.linkedlist;

/**
 * 
 */
public class LinkedListImpl {
	
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBeginning(2);
		linkedList.insertAtBeginning(4);
		linkedList.insertAtBeginning(6);
		linkedList.insertAtBeginning(5);
		linkedList.insertAtBeginning(3);
		linkedList.display();
		
		linkedList.insertAtPosition(3,10);
		
		linkedList.display();
		
		linkedList.deleteAtPosition(3);
	}

}
