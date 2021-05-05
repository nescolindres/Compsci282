package hashtables;

import java.util.Scanner;

public class HashChainApp {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Hash Table Test \n \n");
		System.out.println("Enter Size");
		
		HashTable tree = new HashTable(input.nextInt());
		char ch;
		do {
			System.out.println("\nHash Table Operations\n");
			System.out.println("1.Insert");
			System.out.println("2.size");
			System.out.println("3.Check Empty");
			
			int choice = input.nextInt();
			switch (choice) {
			case 1 : 
				System.out.println("Enter integer element to insert: ");
				tree.insert(input.nextInt());
				break;
			case 2 :
				System.out.println("Size = " + tree.getSize());
			case 3: 
				System.out.println("Empty status = " + tree.isEmpty() );
			}
			tree.printHashTable();
			
			System.out.println("To exit enter n");
			ch = input.next().charAt(0);
			
					
		}
		while (ch != 'n');
	}
	
}
