/**
 * 
 */
package com.dsa.learning.linkedlist;

import java.util.Iterator;

/**
 * 
 */
public class LinkedListImpl {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.insertAtBeginning(2);
		linkedList.insertAtBeginning(4);
		linkedList.insertAtBeginning(6);
		linkedList.insertAtBeginning(5);
		linkedList.insertAtBeginning(3);
		linkedList.display();
		
		linkedList.insertAtPosition(3,10);
		
		linkedList.display();
		
		
		linkedList.getValueAtPosition(2);
		linkedList.updateAtPosition(0,6);
		
		linkedList.deleteAtEnd();
		linkedList.insertAtEnd(7);
		linkedList.searchValue(7);
		linkedList.containsValue(3);
		
		Iterator<Integer> it = linkedList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("");
		linkedList.displayFromIterator(linkedList);
	}

}
