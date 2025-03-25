/**
 * 
 */
package com.dsa.learning.arraylist;

import java.util.Scanner;

/**
 * 
 */
public class DynamicArrayImpl {


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int val, position = 0;
		Scanner sc = new Scanner(System.in);
		DynamicArray<Integer> list = new DynamicArray<Integer>();
		while(true) {
			System.out.println("-----List Menu-----");
			System.out.println("1. Insert at End");
			System.out.println("2. Display the List");
			System.out.println("3. Insert at a specific position");
			System.out.println("4. Delete from specific position");
			System.out.println("5. Delete at end");
			System.out.println("6. Exit\n");
			System.out.println("7. Delete from beginning");
			System.out.println("8. Insert at beginning");
			System.out.println("9. Get the position of the value");
			System.out.println("10. Update value at any position");
			System.out.println("11. Search value");
			System.out.println("12. Clear the list");

			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: System.out.println("Enter the data");
			val = sc.nextInt();
			list.add(val);
			break;
			case 2: list.display();
			System.out.print("The integer present in this list are:");
			for(Integer a:list) {
				System.out.print(a + " ");
			}
			break;
			case 3: System.out.println("Enter the position(Position starts at 0):");
			position = sc.nextInt();
			if(position < 0) {
				System.out.println("Invalid Position");
				break;
			}
			System.out.println("Enter the data:");
			val = sc.nextInt();
			list.insertAtPosition(position, val);
			break;
			case 4: System.out.println("Enter the position(Position starts at 0):");
			position = sc.nextInt();
			if(position < 0) {
				System.out.println("Invalid Position");
				break;
			}
			list.deleteAtPosition(position);
			break;
			case 5: 
				list.deleteAtEnd();
				break;
			case 7:
				list.deleteAtPosition(0);
				break;
			case 8: System.out.println("Enter the value to be inserted:");
			val = sc.nextInt();
			list.insertAtPosition(0, val);
			break;
			case 9: System.out.println("Enter the value to be updated:");
			val = sc.nextInt();
			list.update(position, val);
			break;
			case 10: System.out.println("Enter the value to search");
			val = sc.nextInt();
			System.out.println("Index of the value is " + list.search(val));
			case 11: list.clear();
			break;
			case 12: System.out.println("Enter the value to find:");
			val = sc.nextInt();
			System.out.println("The value is " + list.contains(val));
			break;
			case 6: System.exit(0);

			default: System.err.println("Invalid Choice");
			}
		}
	}
}
